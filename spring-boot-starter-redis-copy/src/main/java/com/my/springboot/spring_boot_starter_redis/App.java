//package com.my.springboot.spring_boot_starter_redis;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//
//import com.my.springboot.spring_boot_starter_redis.bean.RedisToolUtils;
//import com.my.springboot.spring_boot_starter_redis.testservice.TestServiceImpl;
//
//import redis.clients.jedis.Jedis;
//
//@SpringBootApplication
//public class App 
//{	
//    public static void main( String[] args )
//    {
//    	ConfigurableApplicationContext context  =  SpringApplication.run(App.class, args);
//    	
////    	String[] nameStrings = context.getBeanDefinitionNames();
////    	for (String string : nameStrings) {
////			System.out.println(string);
////		}
//    	
////    	context.getBean(Jedis.class).set("ww", "234567890");
//    	
//    	RedisToolUtils.set("kk","oooo");
//    	
//    	TestServiceImpl testServiceImpl = context.getBean(TestServiceImpl.class);
//    	testServiceImpl.testServiceMethod();
//    	testServiceImpl.testServiceMethod();
//    	testServiceImpl.testServiceMethod();
//    	context.close();
//    }
//}
