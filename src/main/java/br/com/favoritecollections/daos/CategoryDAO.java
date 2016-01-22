package br.com.favoritecollections.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.favoritecollections.models.Category;

@Repository
public class CategoryDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Category category) {
		manager.persist(category);
	}

	public List<Category> list() {
		return manager.createQuery(
				"select c from Category c", 
				Category.class).getResultList();
	}
}
