package myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import myhouse.entity.Type;

@Repository
public interface TypeMapper {
	@Insert("INSERT INTO `Type` (`name`) VALUES(#{name})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public int add(Type Type);

	@Delete("DELETE FROM `Type` WHERE Id = #{id}")
	public int delete(@Param("id") int id);

	@Update("UPDATE `Type` SET `name` = #{name} WHERE Id = #{id}")
	public int update(Type Type);

	@Select("SELECT * FROM Type WHERE Id = #{id}")
	public Type getTypeById(@Param("id") int id);

	@Select("SELECT * FROM Type WHERE `name` = #{name}")
	public Type checkNameByUse(@Param("name") String name);

	@Select("SELECT * FROM Type")
	public List<Type> getAll();
}
