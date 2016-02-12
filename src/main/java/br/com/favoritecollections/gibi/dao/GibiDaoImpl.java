package br.com.favoritecollections.gibi.dao;

import org.springframework.stereotype.Repository;

import br.com.favoritecollections.dao.GenericDaoImpl;
import br.com.favoritecollections.gibi.model.Gibi;

@Repository
public class GibiDaoImpl extends GenericDaoImpl<Gibi, Integer> 
	implements GibiDao {

}
