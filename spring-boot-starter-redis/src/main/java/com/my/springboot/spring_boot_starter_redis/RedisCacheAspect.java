package com.my.springboot.spring_boot_starter_redis;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
@Aspect
public class RedisCacheAspect {

	@Autowired
	private Environment env;
	
	/**
	 * 标记RedisCache注解当做切点
	 */
	@Pointcut("@annotation(com.my.springboot.spring_boot_starter_redis.RedisCache)")
	public void pointcut() {
		
	}
	
	/**
	 * 获取缓存的key key 定义在注解上，支持SPEL表达式
	 * 
	 * @param pjp
	 * @return
	 */
	private String getSelDefKey(ProceedingJoinPoint pjp) {
		// 获取类名-全路径
		String classType = pjp.getTarget().getClass().getName();
		//获取方法名
		String methodName = pjp.getSignature().getName();
		//获取字符串数组的参数
		Object[]  paramterArray = (Object[]) pjp.getArgs();
		String paramterStr = Arrays.toString(paramterArray);
		//组装唯一key
		String key = classType + "." + methodName + "." + paramterStr;
		return key;
	}
	
	@Around("pointcut()")
	public Object redisCacheMethod(ProceedingJoinPoint pjp) throws Throwable {
		//全局统一配置，用于redis集群挂机后，标记为不再使用缓存
		String openFlag = env.getProperty("my.redis.cache.isOpen") == null ? "true" : env.getProperty("my.redis.cache.isOpen");
		Boolean cacheEnable = Boolean.valueOf(openFlag);
		// 判断是否需要拦截
		if (!cacheEnable) {
			try {
				pjp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		/**
		 * 把方法所在全路径+方法名+参数作为一个关键key，不会重复
		 */
		String key = getSelDefKey(pjp);
		
		//获取注解参数
		Method method = getMethod(pjp);
		RedisCache redisCache = method.getAnnotation(RedisCache.class);
		
		// 获取方法的返回类型,让缓存可以返回正确的类型
		Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();
		Object result = RedisToolUtils.get(key);
		if (result == null) {
			result = pjp.proceed();
			if(result !=null){
				//只有数据库返回对象才会存储缓存，避免无用的null字符串对象遭受攻击造成redis服务器的内存移除
				String temp = com.alibaba.fastjson.JSONObject.toJSONString(result);
				//存储类型采用json字符串
				RedisToolUtils.setex(key, redisCache.expireTime(), temp);
			}
		} else {
			//找到直接返回缓存的结果，转为可用的类型
			result = JSONObject.parseObject((String) result, returnType);
		}
		return result;
	}
	
	/**
	 * 获取被拦截方法对象
	 * MethodSignature.getMethod() 获取的是顶层接口或者父类的方法对象 而缓存的注解在实现类的方法上
	 * 所以应该使用反射获取当前对象的方法对象
	 */
	public Method getMethod(ProceedingJoinPoint pjp) {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		return method;
	}
}
