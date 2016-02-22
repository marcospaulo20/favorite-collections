package br.com.favoritecollections.gibi.dao;

import org.springframework.stereotype.Repository;

import br.com.favoritecollections.dao.GenericDaoImpl;
import br.com.favoritecollections.gibi.model.PublishingCompany;

@Repository
public class PublishingCompanyDaoImpl extends GenericDaoImpl<PublishingCompany, Integer> implements PublishingCompanyDao {

}
