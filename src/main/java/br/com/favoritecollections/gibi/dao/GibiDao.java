package br.com.favoritecollections.gibi.dao;

import br.com.favoritecollections.dao.GenericDao;
import br.com.favoritecollections.gibi.model.Gibi;

public interface GibiDao extends GenericDao<Gibi, Integer> {
	public Gibi getGibi(Integer id);
}
