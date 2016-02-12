package br.com.favoritecollections.gibi.service;

import java.util.List;

import br.com.favoritecollections.gibi.model.Edition;
import br.com.favoritecollections.service.GenericService;

public interface EditionService extends GenericService<Edition, Integer> {

	public List<Edition> findByGibiUsername(String name);
}
