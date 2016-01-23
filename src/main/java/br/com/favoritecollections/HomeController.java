package br.com.favoritecollections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.favoritecollections.model.Menu;
import br.com.favoritecollections.service.MenuService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		List<Menu> menus = menuService.listMenu();
		if(menus.isEmpty())  {
			System.out.println("Menu esta vazio");
		}
		return "index";
	}
}
