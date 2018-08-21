//package com.my.springboot.spring_boot_starter_redis;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.my.springboot.spring_boot_starter_redis.testservice.TestServiceImpl;
//
//public class App2 {
//
//	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
////		System.out.println(context.getBean(RedisProperties.class));
////		System.out.println(context.getBean(RedisCacheAspect.class));
////		System.out.println(context.getBean(RedisClient.class));
////		
////		Environment environment = context.getBean(Environment.class);
////		System.out.println("-----"+environment.getProperty("my.redis.host"));
////		
////		System.out.println("---" + context.getBean(RedisProperties.class).getPort());
////		
////		RedisToolUtils.set("qq", "qq");
////		
////		RedisToolUtils.set("day00ForProperties.TestServiceImpl2.testServiceMethod.[]", "hahaha");
//		
//		TestServiceImpl testServiceImpl = context.getBean(TestServiceImpl.class);
//		testServiceImpl.testServiceMethod();
//		testServiceImpl.testServiceMethod();
//		testServiceImpl.testServiceMethod();
//		context.close();
//		System.out.println("----end-----");
//	}
//}
