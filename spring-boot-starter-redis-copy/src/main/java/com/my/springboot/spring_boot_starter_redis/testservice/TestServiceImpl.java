package com.my.springboot.spring_boot_starter_redis.testservice;

import org.springframework.stereotype.Service;

import com.my.springboot.spring_boot_starter_redis.bean.RedisCache;

@Service
public class TestServiceImpl {

	@RedisCache(expireTime=3600)
	public String testServiceMethod() {
		System.out.println("我即将查询数据库了");
		return "hahaha";
	}
}
