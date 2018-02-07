package myhouse.service;

import org.apache.ibatis.annotations.Param;

import myhouse.entity.User;

public interface UserService {
	public User adminLogin(@Param("userName") String userName, @Param("password") String password);
}
