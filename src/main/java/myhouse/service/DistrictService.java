package myhouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import myhouse.entity.District;

public interface DistrictService {
	public int add(District district);

	public int delete(@Param("id") int id);

	public int update(District district);

	public District getDistrictById(@Param("id") int id);

	public District checkNameByUse(@Param("name") String name);

	public List<District> getAll();
}
