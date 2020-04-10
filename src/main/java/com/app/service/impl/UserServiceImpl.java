package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserRepository userDao;
	
	@Override
	public User getUserbyId(int userId) {
		System.out.println("---------------");
		User user = userDao.selectByPrimaryKey(userId);
		return user;
	}
}
