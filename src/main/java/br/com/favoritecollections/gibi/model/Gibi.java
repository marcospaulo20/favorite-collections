package br.com.favoritecollections.gibi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "gibi")
public class Gibi {

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name_gibi", nullable = false)
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name = "published", nullable = false)
	private Date published;
	@Column(name = "publishing_company", nullable = false)
	private String publishingCompany;	
	@Column(name = "licensor")
	private String licensor;
	@Column(name = "genre", nullable = false)
	private String genre;
	@Column(name = "status_gibi", nullable = false)
	private String statusGibi;
	@Column(name = "date_register", nullable = false)
	private Date dateRegister;
	
	@OneToMany(mappedBy = "gibi", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Edition> editions = new HashSet<Edition>();
	
	public Gibi() {  }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public String getLicensor() {
		return licensor;
	}

	public void setLicensor(String licensor) {
		this.licensor = licensor;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getStatusGibi() {
		return statusGibi;
	}

	public void setStatusGibi(String statusGibi) {
		this.statusGibi = statusGibi;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Set<Edition> getEditions() {
		return editions;
	}
	
	public void setEditions(Set<Edition> editions) {
		this.editions = editions;
	}
	
}
