package com.my.springboot.spring_boot_starter_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.my.springboot.spring_boot_starter_redis.testservice.TestServiceImpl;

import redis.clients.jedis.Jedis;

/**
 * 方式一
 * @author yp-tc-m-7129
 *
 */
//@EnableRedis
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context  =  SpringApplication.run(App.class, args);
//    	context.getBean(Jedis.class).set("ww", "234567890");
    	
//    	RedisToolUtils.setex("com.my.springboot.spring_boot_starter_redis.testservice.TestServiceImpl.testServiceMethod.[]", 3600, "oooo");
    	
    	TestServiceImpl testServiceImpl = context.getBean(TestServiceImpl.class);
    	testServiceImpl.testServiceMethod();
    	testServiceImpl.testServiceMethod();
    	testServiceImpl.testServiceMethod();
    }
}
