package myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import myhouse.entity.District;

@Repository
public interface DistrictMapper {

	@Insert("INSERT INTO `District` (`name`) VALUES(#{name})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public int add(District district);

	@Delete("DELETE FORM `District` WHERE Id = #{id}")
	public int delete(@Param("id") int id);

	@Update("UPDATE `District` SET `name` = #{name} WHERE Id = #{id}")
	public int update(District district);

	@Select("SELECT * FROM District WHERE Id = #{id}")
	public District getDistrictById(@Param("id") int id);
	
	@Select("SELECT * FROM District WHERE `name` = #{name}")
	public District checkNameByUse(@Param("name") String name);
	
	@Select("SELECT * FROM District")
	public List<District> getAll();
}
