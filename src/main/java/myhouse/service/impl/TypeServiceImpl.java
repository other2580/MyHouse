package myhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myhouse.dao.TypeMapper;
import myhouse.entity.Type;
import myhouse.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeMapper typeMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int add(Type Type) {
		return typeMapper.add(Type);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int delete(int id) {
		return typeMapper.delete(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 60)
	public int update(Type Type) {
		return typeMapper.update(Type);
	}

	@Override
	public Type checkNameByUse(String name) {
		return typeMapper.checkNameByUse(name);
	}
	@Override
	public Type getTypeById(int id) {
		return typeMapper.getTypeById(id);
	}

	@Override
	public List<Type> getAll() {
		return typeMapper.getAll();
	}

}
