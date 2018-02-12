package com.cn.my.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Component
public class CacheUtil{

	@Autowired
	private JedisPool jedisPool;
	
	public boolean put2Cache(String cacheKey, String value)  {
		String result = jedisPool.getResource().set(cacheKey, value);
		return "success".equals(result);
	}
	
	public boolean put2Cache(String cacheKey, String value, int seconds)  {
		String result = jedisPool.getResource().setex(cacheKey, seconds, value);
		return "success".equals(result);
	}
	
	public String getFromCache(String cacheKey)  {
		return jedisPool.getResource().get(cacheKey);
	}
	
	public long incr(String key) {
		return jedisPool.getResource().incr(key);
	}
	
	public long decr(String key) {
		return jedisPool.getResource().decr(key);
	}

	public String putMap(String key, Map<String, String> map) {
		return jedisPool.getResource().hmset(key, map);
	}

	public Map<String, String> getMap(String key) {
		return jedisPool.getResource().hgetAll(key);
	}
	
	public Long lpush(String key, String... values) {
		return jedisPool.getResource().lpush(key, values);
	}
	
	public Long rpush(String key, String... values) {
		return jedisPool.getResource().rpush(key, values);
	}
	
	public String lpop(String key) {
		return jedisPool.getResource().lpop(key);
	}
	
	public String rpop(String key) {
		return jedisPool.getResource().rpop(key);
	}


	public Long del(String key) {
		return jedisPool.getResource().del(key);
	}
}