package br.com.favoritecollections.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_genre")
public class Genre {

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name", length = 80, nullable = false)
	private String name;

	public Genre() {	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
