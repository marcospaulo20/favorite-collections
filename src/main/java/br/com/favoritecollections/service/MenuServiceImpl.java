package br.com.favoritecollections.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.favoritecollections.dao.MenuDao;
import br.com.favoritecollections.model.Menu;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> listMenu() {
		return this.menuDao.listMenu();
	}
}