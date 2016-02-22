package br.com.favoritecollections.gibi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.favoritecollections.dao.GenericDao;
import br.com.favoritecollections.gibi.dao.EditionDao;
import br.com.favoritecollections.gibi.model.Edition;
import br.com.favoritecollections.service.GenericServiceImpl;

@Service
public class EditionServiceImpl extends GenericServiceImpl<Edition, Integer> 
	implements EditionService {

	private EditionDao editionDao;
	
	public EditionServiceImpl() {	}
	
	@Autowired
	public EditionServiceImpl(
			@Qualifier("editionDaoImpl") GenericDao<Edition, Integer> genericDao) {
		super(genericDao);
		this.editionDao = (EditionDao) genericDao;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Edition getEdition(Integer id) {
		return editionDao.getEdition(id);
	}
}
