package myhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myhouse.dao.UserMapper;
import myhouse.entity.User;
import myhouse.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int register(User user) {
		return userMapper.register(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int delete(int id) {
		return userMapper.delete(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int modifyByUse(int id, int isInUse) {
		return userMapper.modifyByUse(id, isInUse);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int modifyByAdmin(int id, int isAdmin) {
		return userMapper.modifyByAdmin(id, isAdmin);
	}
	
	@Override
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}

	@Override
	public User login(String userName, String password) {
		return userMapper.login(userName, password);
	}

	@Override
	public User adminLogin(String userName, String password) {
		return userMapper.adminLogin(userName, password);
	}

	@Override
	public User checkUserNameByUse(String userName) {
		return userMapper.checkUserNameByUse(userName);
	}

	@Override
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}

	@Override
	public int fetchUserRows(int isAdmin, int isInUse, String userName) {
		return userMapper.fetchUserRows(isAdmin, isInUse, userName);
	}

	@Override
	public List<User> getUserPagings(int isAdmin, int isInUse, String userName,
			int start, int lengt) {
		return userMapper.getUserPagings(isAdmin, isInUse, userName, start,
				lengt);
	}

	@Override
	public List<String> getUserByPrefix(String prefix) {
		return userMapper.getUserByPrefix(prefix);
	}

}
