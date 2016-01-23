package br.com.favoritecollections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainTemplateController {

	@RequestMapping(value = "/users/list")
	public String getMenusListViews() {
		return "views/menu/list";
		
	}
}
