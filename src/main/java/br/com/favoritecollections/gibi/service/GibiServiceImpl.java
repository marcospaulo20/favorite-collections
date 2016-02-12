package br.com.favoritecollections.gibi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.favoritecollections.dao.GenericDao;
import br.com.favoritecollections.gibi.dao.GibiDao;
import br.com.favoritecollections.gibi.model.Gibi;
import br.com.favoritecollections.service.GenericServiceImpl;

@Service
public class GibiServiceImpl extends GenericServiceImpl<Gibi, Integer> 
	implements GibiService {
	
	private GibiDao gibiDao;
	
	public GibiServiceImpl() {	}
	
	@Autowired
	public GibiServiceImpl(
			@Qualifier("gibiDaoImpl") GenericDao<Gibi, Integer> genericDao) {
		super(genericDao);
		this.gibiDao = (GibiDao) genericDao;
	}
	
}
