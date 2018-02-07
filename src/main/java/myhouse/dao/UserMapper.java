package myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import myhouse.entity.User;

@Repository
public interface UserMapper {

	@Insert("INSERT INTO `USER` (`Username`, `PASSWORD`, `NAME`, `Phone`, `Email`,`IsAdmin`, `IsInUse`) VALUES (#{userName}, #{password}, #{name}, #{phone}, #{email}, #{isAdmin}, #{isInUse})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public int register(User user);

	@Delete("DELETE FROM `User` WHERE `id` = #{id}")
	public int delete(@Param("id") int id);

	@Update("UPDATE `User` SET `Username` = #{userName}, `PASSWORD` = #{password}, `NAME` = #{name}, `Phone` = #{phone}, `Email` = #{email},`IsAdmin` = #{isAdmin}, `IsInUse` = #{isInUse} WHERE `id` = #{id}")
	public int update(User user);

	@Update("UPDATE `User` SET `IsInUse` = #{isInUse} WHERE `id` = #{id}")
	public int modifyByUse(@Param("id") int id, @Param("isInUse") int isInUse);

	@Select("SELECT * FROM `User` WHERE `id` = #{id}")
	public User getUserById(@Param("id") int id);

	@Select("SELECT * FROM `User` WHERE `userName` = #{userName} AND `password` = #{password}")
	public User login(@Param("userName") String userName, @Param("password") String password);
	
	@Select("SELECT * FROM `User` WHERE `userName` = #{userName} AND `password` = #{password} AND IsAdmin = 1")
	public User adminLogin(@Param("userName") String userName, @Param("password") String password);

	@Select("SELECT * FROM `User` WHERE `userName` = #{userName}")
	public User checkUserNameByUse(@Param("userName") String userName);

	@Select("SELECT * FROM `User`")
	public List<User> getAllUser();
}
