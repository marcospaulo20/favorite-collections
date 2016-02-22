package br.com.favoritecollections.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_image")
public class Image {

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@Column(name = "url", length = 255, nullable = false)
	private String url;
	
	public Image() {	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}