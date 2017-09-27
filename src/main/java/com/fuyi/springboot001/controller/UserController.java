package com.fuyi.springboot001.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuyi.springboot001.domain.User;
import com.fuyi.springboot001.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("hello")
	public String showHello() {
		return "Hello World!!!";
	}
	
	/**
	 * 返回pojo
	 * @return
	 */
	@RequestMapping("pojo")
	public User showUser() {
		User user = new User();
		user.setId(1);
		user.setUsername("张三");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("武当山");
		return user;
	}
	
	/**
	 * 返回Map
	 */
	@RequestMapping("maps")
	public Map<String, Object> showMaps() {
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("username", "张三风");
		maps.put("age", 18);
		return maps;
	}
	
	/**
	 * 返回List
	 */
	@RequestMapping("list")
	public List<User> showList() {
		List<User> list = new ArrayList<User>();
		
		User user = new User();
		user.setId(1);
		user.setUsername("张三");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("武当山");
		list.add(user);
		
		User user1 = new User();
		user1.setId(2);
		user1.setUsername("张三1");
		user1.setBirthday(new Date());
		user1.setSex("女");
		user1.setAddress("武当山1");
		list.add(user1);
		
		return list;
	}
	
	/**
	 * 整合ssm
	 */
	@RequestMapping("ssm")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	/**
	 * 查询redis集群服务
	 */
	@RequestMapping("redis")
	public String findRedis() {
		return userService.findRedis();
	}
}
