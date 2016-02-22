package br.com.favoritecollections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainTemplateController {
	
	// Animação
	@RequestMapping(value = "animacao/show")
	public String getAnimacaoShow() {
		return "views/animacao/show";
	}
	
	// Gibi
	@RequestMapping(value = "gibi/show")
	public String getGibiShow() {
		return "views/gibi/show";
	}
	
	/*
	 * Saint Seiya - Os Cavaleiros do Zodiacos
	 * Anime e Gibi
	 */
	
	// Saint Seiya - Gibi
	@RequestMapping(value = "saint_seiya/index")
	public String getAnimacaoSaintSeiyaView() {
		return "views/animacao/saint_seiya/index";
	}
	
	@RequestMapping(value = "saint_seiya/gibi/publishingCompany")
	public String getAnimacaoSaintSeiyaGibiView() {
		return "views/animacao/saint_seiya/gibi/publishingCompany.tmpl";
	}
	
	@RequestMapping(value = "saint_seiya/gibi/publishingCompany/{id}")
	public String getAnimacaoSaintSeiyaGibiEditPublishingCompanyView() {
		return "views/animacao/saint_seiya/gibi/edit-publishingCompany";
	}
	
	@RequestMapping(value = "saint_seiya/gibi/edition")
	public String getAnimacaoSaintSeiyaGibiEditionView() {
		return "views/animacao/saint_seiya/gibi/edition.tmpl";
	}
	
	/* Gibis
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
	*/
}
