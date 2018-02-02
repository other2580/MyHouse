package myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import myhouse.entity.Street;

@Repository
public interface StreetMapper {
	@Insert("INSERT INTO `Street` (`NAME`, `DistrictId`) VALUES(#{name}, #{districtId})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public int add(Street Street);

	@Delete("DELETE FORM `Street` WHERE Id = #{id}")
	public int delete(@Param("id") int id);

	@Update("UPDATE `Street` SET `name` = #{name}, `DistrictId` = #{districtId} WHERE Id = #{id}")
	public int update(Street Street);

	@Select("SELECT * FROM Street WHERE Id = #{id}")
	public Street getStreetById(@Param("id") int id);

	@Select("SELECT * FROM Street WHERE `name` = #{name}")
	public Street checkNameByUse(@Param("name") String name);

	@Select("SELECT * FROM Street")
	public List<Street> getAll();
}
