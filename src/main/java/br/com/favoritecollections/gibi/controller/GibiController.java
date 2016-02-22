package br.com.favoritecollections.gibi.controller;

import org.springframework.stereotype.Controller;

@Controller
//@RequestMapping("/gibi")
public class GibiController {
	/*
	@Autowired
	GibiService gibiService;
	
	@Autowired
	EditionService editionService;
	
	@RequestMapping(method = RequestMethod.GET)
	// @Cacheable(value="lastGibi")
	public ResponseEntity <List<Gibi>> getAll() {
		List<Gibi> gibis = gibiService.getAll();
		
		if(gibis.isEmpty()){
			return new ResponseEntity<List<Gibi>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Gibi>>(gibis, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.PUT)
	public ResponseEntity<Void> save(@RequestBody Gibi gibi) {
		if(gibi.getId() == 0) {
			gibiService.add(gibi);
			
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)	
	public ResponseEntity<Gibi> update(@PathVariable("id") Integer id, @RequestBody Gibi gibi) {
		
		Gibi currentGibi = gibiService.get(id);
		
		if(currentGibi == null) {
			System.out.println("Gibi with id " + id + " not found");
			return new ResponseEntity<Gibi>(HttpStatus.NOT_FOUND);
		}
		
		currentGibi.setName(gibi.getName());
		currentGibi.setPublished(gibi.getPublished());
		currentGibi.setGenre(gibi.getGenre());
		currentGibi.setLicensor(gibi.getLicensor());
		currentGibi.setPublishingCompany(gibi.getPublishingCompany());
		currentGibi.setStatusGibi(gibi.getStatusGibi());
		currentGibi.setDateRegister(new Date());
		
		
		gibiService.update(currentGibi);
		return new ResponseEntity<Gibi>(currentGibi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Gibi> delete(@PathVariable("id") Integer id) {
		Gibi gibi = gibiService.get(id);
		if(gibi == null) {
			System.out.println("Unable to delete. Gibi with id " + id + " not found");
			return new ResponseEntity<Gibi>(HttpStatus.NOT_FOUND);
		}
		
		gibiService.remove(gibi);
		return new ResponseEntity<Gibi>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Gibi> getGibiById(@PathVariable("id") Integer id) {
		Gibi gibi = gibiService.get(id);
		
		if(gibi == null) {
			return new ResponseEntity<Gibi>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Gibi>(gibi, HttpStatus.OK);
	}
	
	// Edition
	@RequestMapping(value = "/{gibiId}/{editionId}", method = RequestMethod.PUT)	
	public ResponseEntity<Edition> updateEdition(@PathVariable("gibiId") Integer gibiId, @PathVariable("editionId") Integer editionId,
			@RequestBody Edition edition) {
		
		Edition currentEdition = editionService.get(editionId);
		
		if(currentEdition == null) {
			System.out.println("Edition with id " + editionId + " not found");
			return new ResponseEntity<Edition>(HttpStatus.NOT_FOUND);
		}
		
		currentEdition.setNumberEdition(edition.getNumberEdition());		
		currentEdition.setDateRegister(new Date());
		
		
		editionService.update(currentEdition);
		return new ResponseEntity<Edition>(currentEdition, HttpStatus.OK);
	}
	*/
}
