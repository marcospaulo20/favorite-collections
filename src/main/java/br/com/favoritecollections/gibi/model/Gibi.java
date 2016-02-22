package br.com.favoritecollections.gibi.model;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.favoritecollections.model.Genre;
import br.com.favoritecollections.model.Image;
import br.com.favoritecollections.model.Product;
import br.com.favoritecollections.model.Status;

@Entity
@Table(name = "tbgib_gibi")
public class Gibi {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@OneToOne
	@JoinColumn(name = "status_id")
	private Status status;
	
	@OneToOne
	@JoinColumn(name = "image_id")
	private Image imageGibi;

	@Column(name = "written", length = 100, nullable = false)
	private String written;
	@Column(name = "magazine", length = 100)
	private String magazine;
	@Column(name = "licensor", length = 100)
	private String licensor;
	@Column(name = "published_initial", nullable = false)
	private Date publishedInitial;
	@Column(name = "published_final")
	private Date publishedFinal;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "gibi_publishing_company",
			joinColumns = {@JoinColumn(name="gibi_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="publishing_company_id", referencedColumnName="id")})
	private List<PublishingCompany> publishingCompanys;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "gibi_genre",
			joinColumns = {@JoinColumn(name="gibi_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="genre_id", referencedColumnName="id")})
	private List<Genre> genres;

	public Gibi() {	}

	public int getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Image getImageGibi() {
		return imageGibi;
	}

	public void setImageGibi(Image imageGibi) {
		this.imageGibi = imageGibi;
	}

	public String getWritten() {
		return written;
	}

	public void setWritten(String written) {
		this.written = written;
	}

	public String getMagazine() {
		return magazine;
	}

	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}

	public String getLicensor() {
		return licensor;
	}

	public void setLicensor(String licensor) {
		this.licensor = licensor;
	}

	public Date getPublishedInitial() {
		return publishedInitial;
	}

	public void setPublishedInitial(Date publishedInitial) {
		this.publishedInitial = publishedInitial;
	}

	public Date getPublishedFinal() {
		return publishedFinal;
	}

	public void setPublishedFinal(Date publishedFinal) {
		this.publishedFinal = publishedFinal;
	}

	public List<PublishingCompany> getPublishingCompanys() {
		return publishingCompanys;
	}

	public void setPublishingCompanys(List<PublishingCompany> publishingCompanys) {
		this.publishingCompanys = publishingCompanys;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	
	
}
