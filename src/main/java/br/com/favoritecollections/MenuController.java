package br.com.favoritecollections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.favoritecollections.model.Menu;
import br.com.favoritecollections.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	MenuService menuService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<Menu>> getAll() {
		List<Menu> menus = menuService.listMenu();
		if(menus.isEmpty()){
			return new ResponseEntity<List<Menu>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}
	
}
