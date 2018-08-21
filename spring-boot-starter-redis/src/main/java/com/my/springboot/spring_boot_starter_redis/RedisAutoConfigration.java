//package com.my.springboot.spring_boot_starter_redis;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import redis.clients.jedis.Jedis;
//
///**
// * 当存在Jedis的时候下面的所有配置才生效
// * 配置类
// * Redis资源文件的内容映射到RedisProperties类中，并且把这个类加入到spring容器中，适用于被其他项目使用无法直接使用@bean的情况
// * @author yp-tc-m-7129
// *
// */
////@Configuration
//@ConditionalOnClass(Jedis.class)
//@EnableConfigurationProperties(RedisProperties.class)
//public class RedisAutoConfigration {
//
//	@Bean
//	@ConditionalOnMissingBean
//	public Jedis jedis(RedisProperties redisProperties) {
//		System.out.println("======RedisAutoConfigration=======");
//		return new Jedis(redisProperties.getHost(), redisProperties.getPort());
//	}
//}
