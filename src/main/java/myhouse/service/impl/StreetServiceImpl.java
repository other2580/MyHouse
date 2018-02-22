package myhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myhouse.dao.StreetMapper;
import myhouse.entity.Street;
import myhouse.service.StreetService;

@Service
public class StreetServiceImpl implements StreetService {

	@Autowired
	private StreetMapper streetMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int add(Street Street) {
		return streetMapper.add(Street);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int delete(int id) {
		return streetMapper.delete(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int update(Street Street) {
		return streetMapper.update(Street);
	}

	@Override
	public Street getStreetById(int id) {
		return streetMapper.getStreetById(id);
	}

	@Override
	public Street checkNameByUse(String name) {
		return streetMapper.checkNameByUse(name);
	}

	@Override
	public List<Street> getAll() {
		return streetMapper.getAll();
	}

	@Override
	public List<Street> getStreetByDistrictId(int districtId) {
		return streetMapper.getStreetByDistrictId(districtId);
	}

	@Override
	public int fetchStreetRows(int districtId, String streetName) {
		return streetMapper.fetchStreetRows(districtId, streetName);
	}

	@Override
	public List<Street> getStreetsPagings(int districtId, String streetName,
			int start, int length) {
		return streetMapper.getStreetsPagings(districtId, streetName, start,
				length);
	}

	@Override
	public List<String> getStreetByPrefix(String prefix) {
		return streetMapper.getStreetByPrefix(prefix);
	}
}
