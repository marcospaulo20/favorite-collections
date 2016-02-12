package br.com.favoritecollections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainTemplateController {
	
	// Gibis
	@RequestMapping(value = "/gibis/list")
	public String getGibisListViews() {
		return "views/gibi/list";
	}
	
	@RequestMapping(value = "/gibi/show/{id}")
	public String getGibiShowViews() {
		return "views/gibi/show";
	}
	
	@RequestMapping(value = "/gibi/edit/{id}")
	public String getGibiEditViews() {
		return "views/gibi/edit";
	}
	
	// Editions
	@RequestMapping(value = "/gibi/edition/show")
	public String getEditionEditViews() {
		return "views/edition/show";
	}
}
