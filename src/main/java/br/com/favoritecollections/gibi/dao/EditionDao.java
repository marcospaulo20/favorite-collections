package br.com.favoritecollections.gibi.dao;

import java.util.List;

import br.com.favoritecollections.dao.GenericDao;
import br.com.favoritecollections.gibi.model.Edition;

public interface EditionDao extends GenericDao<Edition, Integer> {

	public List<Edition> findByGibiUsername(String name);
}
