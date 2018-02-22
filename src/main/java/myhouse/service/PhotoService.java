package myhouse.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import myhouse.entity.Photo;

public interface PhotoService {
	public int add(Photo photo);

	public int delete(@Param("houseId") int houseId);

	public int update(Photo photo);

	public List<Photo> getPhotoByHouseIdId(@Param("houseId") int houseId);
}
