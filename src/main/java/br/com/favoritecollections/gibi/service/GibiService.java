package br.com.favoritecollections.gibi.service;

import br.com.favoritecollections.gibi.model.Gibi;
import br.com.favoritecollections.service.GenericService;

public interface GibiService extends GenericService<Gibi, Integer> {

	public Gibi getGibi(Integer id);
}
