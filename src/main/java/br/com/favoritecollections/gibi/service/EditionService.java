package br.com.favoritecollections.gibi.service;

import br.com.favoritecollections.gibi.model.Edition;
import br.com.favoritecollections.service.GenericService;

public interface EditionService extends GenericService<Edition, Integer> {

	public Edition getEdition(Integer id);
}
