package myhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myhouse.dao.HouseMapper;
import myhouse.entity.House;
import myhouse.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseMapper houseMappper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int add(House house) {
		return houseMappper.add(house);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int delete(int id) {
		return houseMappper.delete(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int update(House house) {
		return houseMappper.update(house);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int modifyState(int id, int state) {
		return houseMappper.modifyState(id, state);
	}

	@Override
	public House getHouseById(int id) {
		return houseMappper.getHouseById(id);
	}

	@Override
	public List<House> getAll() {
		if (houseMappper == null)
			System.err.println("is Null");
		return houseMappper.getAll();
	}

	@Override
	public int fetchHouseRows(int userId, int districtId, int streetId,
			int typeId, double minPrice, double maxPrice, int state) {
		return houseMappper.fetchHouseRows(userId, districtId, streetId, typeId,
				minPrice, maxPrice, state);
	}

	@Override
	public List<House> getHousesPagings(int userId, int districtId,
			int streetId, int typeId, double minPrice, double maxPrice,
			int state, int start, int length) {
		return houseMappper.getHousesPagings(userId, districtId, streetId,
				typeId, minPrice, maxPrice, state, start, length);
	}

	public static void main(String[] args) {
		for (House house : new HouseServiceImpl().getAll()) {
			System.out.println(house.getTopic());
		}
	}

}
