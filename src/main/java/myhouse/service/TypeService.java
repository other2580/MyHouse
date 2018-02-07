package myhouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import myhouse.entity.Type;

public interface TypeService {

	public int add(Type Type);

	public int delete(@Param("id") int id);

	public int update(Type Type);

	public Type checkNameByUse(@Param("name") String name);

	public Type getTypeById(@Param("id") int id);

	public List<Type> getAll();
}
