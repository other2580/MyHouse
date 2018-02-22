package myhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myhouse.dao.PhotoMapper;
import myhouse.entity.Photo;
import myhouse.service.PhotoService;
@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoMapper photoMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int add(Photo photo) {
		return photoMapper.add(photo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int delete(int houseId) {
		return photoMapper.delete(houseId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int update(Photo photo) {
		return photoMapper.update(photo);
	}

	@Override
	public List<Photo> getPhotoByHouseIdId(int houseId) {
		return photoMapper.getPhotoByHouseIdId(houseId);
	}
}
