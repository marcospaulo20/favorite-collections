package br.com.favoritecollections.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.favoritecollections.model.Menu;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	@SuppressWarnings("unchecked")
	public List<Menu> listMenu() {
		return getCurrentSession().createQuery("from Menu").list();        
	}
}
