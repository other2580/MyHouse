package myhouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import myhouse.entity.User;

@Repository
public interface UserMapper {

	public int register(User user);

	public int delete(@Param("id") int id);

	public int update(User user);

	public int modifyByUse(@Param("id") int id, @Param("isInUse") int isInUse);

	public int modifyByAdmin(@Param("id") int id,
			@Param("isAdmin") int isAdmin);

	public User getUserById(@Param("id") int id);

	public User login(@Param("userName") String userName,
			@Param("password") String password);

	public User adminLogin(@Param("userName") String userName,
			@Param("password") String password);

	public User checkUserNameByUse(@Param("userName") String userName);

	public List<User> getAllUser();

	public int fetchUserRows(@Param("isAdmin") int isAdmin,
			@Param("isInUse") int isInUse, @Param("userName") String userName);

	public List<User> getUserPagings(@Param("isAdmin") int isAdmin,
			@Param("isInUse") int isInUse, @Param("userName") String userName,
			@Param("start") int start, @Param("length") int lengt);

	public List<String> getUserByPrefix(@Param("prefix") String prefix);

	public Map<String, Object> getUserIdByPrefix(
			@Param("prefix") String prefix);

	public List<User> getUserInfo();

	public int modifyPwd(@Param("password") String password,
			@Param("id") int id);
}