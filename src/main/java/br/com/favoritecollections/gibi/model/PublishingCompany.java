package br.com.favoritecollections.gibi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbgib_publishing_company")
public class PublishingCompany {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@Column(name = "name_edition", length = 100, nullable = false)
	private String nameEdition;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "publishing_company_edition",
			joinColumns = {@JoinColumn(name="publishing_company_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="edition_id", referencedColumnName="id")})
	private List<Edition> editions;

	public PublishingCompany() {	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEdition() {
		return nameEdition;
	}

	public void setNameEdition(String nameEdition) {
		this.nameEdition = nameEdition;
	}

	public List<Edition> getEditions() {
		return editions;
	}

	public void setEditions(List<Edition> editions) {
		this.editions = editions;
	}

}
