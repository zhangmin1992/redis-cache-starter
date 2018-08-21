package com.my.springboot.spring_boot_starter_redis;

import redis.clients.jedis.Jedis;

/**
 * redis 模板操作方法
 *
 * @author：wei.du
 * @since：2015-4-6 下午3:50:22
 * @version:
 */
public interface RedisCall<T> {
    /**
     * 操作
     *
     * @param jedis
     * @return
     */
    public T run(Jedis jedis);
}
