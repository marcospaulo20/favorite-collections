package br.com.favoritecollections.gibi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.favoritecollections.dao.GenericDao;
import br.com.favoritecollections.gibi.dao.PublishingCompanyDao;
import br.com.favoritecollections.gibi.model.PublishingCompany;
import br.com.favoritecollections.service.GenericServiceImpl;

@Service
public class PublishingCompanyServiceImpl extends GenericServiceImpl<PublishingCompany, Integer>
		implements PublishingCompanyService {

	private PublishingCompanyDao publishingCompanyDao;

	public PublishingCompanyServiceImpl() {	}

	@Autowired
	public PublishingCompanyServiceImpl(
			@Qualifier("publishingCompanyDaoImpl") GenericDao<PublishingCompany, Integer> genericDao) {
		super(genericDao);
		this.publishingCompanyDao = (PublishingCompanyDao) genericDao;
	}

}
