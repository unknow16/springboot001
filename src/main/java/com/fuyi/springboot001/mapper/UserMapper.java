package com.fuyi.springboot001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fuyi.springboot001.domain.User;

@Mapper
public interface UserMapper {

	/**
	 * 查询所有的用户
	 */
	public List<User> findAll();
}
