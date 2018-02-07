package myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import myhouse.entity.Type;

@Repository
public interface TypeMapper {
	public int add(Type Type);

	public int delete(@Param("id") int id);

	public int update(Type Type);

	public Type getTypeById(@Param("id") int id);

	public Type checkNameByUse(@Param("name") String name);

	public List<Type> getAll();
}
