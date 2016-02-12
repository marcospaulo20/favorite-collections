package br.com.favoritecollections.gibi.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.favoritecollections.dao.GenericDaoImpl;
import br.com.favoritecollections.gibi.model.Edition;

@Repository
public class EditionDaoImpl extends GenericDaoImpl<Edition, Integer> implements EditionDao {

	@Override
	public List<Edition> findByGibiUsername(String name) {
		Query query = currentSession().createQuery(
				"SELECT e from EDITION e WHERE e.gibi.name=:name");
		query.setParameter("name", name);
		return query.list();

	}
}
