package com.my.springboot.spring_boot_starter_redis.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="classpath:application.properties")
public class RedisProperties {
	
	@Value(value="${my.redis.host}")
	private String host;
	
	@Value(value="${my.redis.database:0}")
	private String database;
	
	@Value(value="${my.redis.password:}")
	private String password;
	
	@Value(value="${my.redis.master:}")
	private String master;
	
	@Value(value="${my.redis.nodes:}")
	private String nodes;
	
	@Value(value="${my.redis.port}")
	private Integer port;
	
	@Value(value="${my.redis.timeout:2000}")
	private Integer timeout;
	
	@Value(value="${my.redis.maxActive:8}")
	private Integer maxActive;
	
	@Value(value="${my.redis.maxWait:-1}")
	private Integer maxWait;
	
	@Value(value="${my.redis.maxIdle:4}")
	private Integer maxIdle;
	
	@Value(value="${my.redis.minIdle:0}")
	private Integer minIdle;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public Integer getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}
	public Integer getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(Integer maxWait) {
		this.maxWait = maxWait;
	}
	public Integer getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}
	public Integer getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public String getNodes() {
		return nodes;
	}
	public void setNodes(String nodes) {
		this.nodes = nodes;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
}
