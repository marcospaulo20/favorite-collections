package br.com.favoritecollections.gibi.dao;

import br.com.favoritecollections.dao.GenericDao;
import br.com.favoritecollections.gibi.model.Edition;

public interface EditionDao extends GenericDao<Edition, Integer> {
	public Edition getEdition(Integer id);
}
