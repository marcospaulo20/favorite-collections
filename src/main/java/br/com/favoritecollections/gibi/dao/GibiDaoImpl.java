package br.com.favoritecollections.gibi.dao;


import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.stereotype.Repository;

import br.com.favoritecollections.dao.GenericDaoImpl;
import br.com.favoritecollections.gibi.model.Gibi;

@Repository
public class GibiDaoImpl extends GenericDaoImpl<Gibi, Integer> 
	implements GibiDao {

	@Override
	public Gibi getGibi(Integer id) {
		Query query = currentSession().createQuery("from Gibi g where id=:id");
		query.setParameter("id", id);
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return (Gibi) query.uniqueResult();
	}

}
