package myhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myhouse.dao.DistrictMapper;
import myhouse.entity.District;
import myhouse.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictMapper districtMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int add(District district) {
		return districtMapper.add(district);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int delete(int id) {
		return districtMapper.delete(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int update(District district) {
		return districtMapper.update(district);
	}

	@Override
	public District getDistrictById(int id) {
		return districtMapper.getDistrictById(id);
	}

	@Override
	public District checkNameByUse(String name) {
		return districtMapper.checkNameByUse(name);
	}

	@Override
	public List<District> getAll() {
		return districtMapper.getAll();
	}

}
