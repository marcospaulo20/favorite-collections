package br.com.favoritecollections.animations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.favoritecollections.gibi.model.Edition;
import br.com.favoritecollections.gibi.model.Gibi;
import br.com.favoritecollections.gibi.model.PublishingCompany;
import br.com.favoritecollections.gibi.service.EditionService;
import br.com.favoritecollections.gibi.service.GibiService;
import br.com.favoritecollections.gibi.service.PublishingCompanyService;

@Controller
@RequestMapping("/saint-seiya")
public class SaintSeiyaController {

	@Autowired
	GibiService gibiService;
	
	@Autowired
	PublishingCompanyService publishingCompanyService;
	
	@Autowired
	EditionService editionService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Gibi> getGibi() {
		Gibi gibi = gibiService.getGibi(1);
		
		if(gibi == null) {
			return new ResponseEntity<Gibi>(HttpStatus.NOT_FOUND);
		}
		System.out.println("Name: " + gibi.getProduct().getName());
		return new ResponseEntity<Gibi>(gibi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<PublishingCompany> getGibiPublishingCompany(@PathVariable("id") Integer id) {
		PublishingCompany publishingCompany = publishingCompanyService.get(id);
		
		if(publishingCompany == null) {
			return new ResponseEntity<PublishingCompany>(HttpStatus.NOT_FOUND);
		}
		System.out.println("Name: " + publishingCompany.getName());
		return new ResponseEntity<PublishingCompany>(publishingCompany, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/{id_}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Edition> getGibiEdition(@PathVariable("id") Integer id, @PathVariable("id_") Integer id_) {
		Edition edition = editionService.getEdition(id_);
		
		if(edition == null) {
			return new ResponseEntity<Edition>(HttpStatus.NOT_FOUND);
		}
		System.out.println("Name: " + edition.getArt());
		return new ResponseEntity<Edition>(edition, HttpStatus.OK);
	}
	
}
