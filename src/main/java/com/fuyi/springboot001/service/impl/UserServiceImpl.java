package com.fuyi.springboot001.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fuyi.springboot001.domain.User;
import com.fuyi.springboot001.mapper.UserMapper;
import com.fuyi.springboot001.service.UserService;

import redis.clients.jedis.JedisCluster;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	//注入REDIS集群对象
	@Autowired
	private JedisCluster jedisCluster;

	/**
	 * redis缓存
	 */
	@Override
	//@Cacheable(value="findAll")
	public List<User> findAll() {
		System.out.println("读数据库");
		return userMapper.findAll();
	}

	@Override
	public String findRedis() {
		jedisCluster.set("username", "Hello world");
		String value = jedisCluster.get("username");
		return value;
	}
}
