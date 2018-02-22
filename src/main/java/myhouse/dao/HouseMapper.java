package myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import myhouse.entity.House;

@Repository
public interface HouseMapper {
	public int add(House house);

	public int delete(@Param("id") int id);

	public int update(House house);

	public int modifyState(@Param("id") int id, @Param("state") int state);

	public House getHouseById(@Param("id") int id);

	public List<House> getAll();

	public int fetchHouseRows(@Param("userId") int userId,
			@Param("districtId") int districtId,
			@Param("streetId") int streetId, @Param("typeId") int typeId,
			@Param("minPrice") double minPrice,
			@Param("maxPrice") double maxPrice, @Param("state") int state);

	public List<House> getHousesPagings(@Param("userId") int userId,
			@Param("districtId") int districtId,
			@Param("streetId") int streetId, @Param("typeId") int typeId,
			@Param("minPrice") double minPrice,
			@Param("maxPrice") double maxPrice, @Param("state") int state,
			@Param("start") int start, @Param("length") int length);
}
