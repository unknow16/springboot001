package com.fuyi.springboot001.service;

import java.util.List;

import com.fuyi.springboot001.domain.User;

public interface UserService {

	/**
	 * 查询所有的用户
	 */
	public List<User> findAll();
	public String findRedis();
}
