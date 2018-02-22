package myhouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import myhouse.entity.Street;

public interface StreetService {
	public int add(Street Street);

	public int delete(@Param("id") int id);

	public int update(Street Street);

	public Street getStreetById(@Param("id") int id);

	public Street checkNameByUse(@Param("name") String name);

	public List<Street> getAll();

	public List<Street> getStreetByDistrictId(
			@Param("districtId") int districtId);

	public int fetchStreetRows(@Param("districtId") int districtId,
			@Param("streetName") String streetName);

	public List<Street> getStreetsPagings(@Param("districtId") int districtId,
			@Param("streetName") String streetName, @Param("start") int start,
			@Param("length") int length);

	public List<String> getStreetByPrefix(@Param("prefix") String prefix);
}
