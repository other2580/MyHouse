package myhouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myhouse.dao.UserMapper;
import myhouse.entity.User;
import myhouse.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User adminLogin(String userName, String password) {
		return userMapper.adminLogin(userName, password);
	}

}
