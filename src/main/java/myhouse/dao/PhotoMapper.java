package myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import myhouse.entity.Photo;

@Repository
public interface PhotoMapper {
	public int add(Photo photo);

	public int delete(@Param("houseId") int houseId);

	public int update(Photo photo);

	public List<Photo> getPhotoByHouseIdId(@Param("houseId") int houseId);
}
