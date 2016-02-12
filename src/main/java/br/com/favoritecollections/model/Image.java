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

	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "url", nullable = false)
	private String url;
	@Column(name = "description")
	private String description;
	@Column(name = "type", nullable = false)
	private String type;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
