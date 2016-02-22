package br.com.favoritecollections.gibi.dao;

import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.stereotype.Repository;

import br.com.favoritecollections.dao.GenericDaoImpl;
import br.com.favoritecollections.gibi.model.Edition;

@Repository
public class EditionDaoImpl extends GenericDaoImpl<Edition, Integer> implements EditionDao {

	@Override
	public Edition getEdition(Integer id) {
		Query query = currentSession().createQuery("from Edition e where id=:id");
		query.setParameter("id", id);
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return (Edition) query.uniqueResult();
	}
}
