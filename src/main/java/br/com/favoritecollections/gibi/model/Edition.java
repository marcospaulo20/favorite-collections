package br.com.favoritecollections.gibi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.favoritecollections.model.Image;

@Entity
@Table(name = "edition")
public class Edition {

	@Id	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "edition_image_id", nullable = false)
	private Image image;
	@Column(name = "number_edition", length = 6, nullable = false)
	private int numberEdition;
	@Column(name = "comic_book_format")
	private String comicBookFormat;
	@Column(name = "cover_price", nullable = false)
	private float coverPrice;
	@Column(name = "date_register", nullable = false)
	private Date dateRegister;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "edition_gibi_id")
	@JsonBackReference
	private Gibi gibi;

	public Edition() {	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getNumberEdition() {
		return numberEdition;
	}

	public void setNumberEdition(int numberEdition) {
		this.numberEdition = numberEdition;
	}

	public String getComicBookFormat() {
		return comicBookFormat;
	}

	public void setComicBookFormat(String comicBookFormat) {
		this.comicBookFormat = comicBookFormat;
	}

	public float getCoverPrice() {
		return coverPrice;
	}

	public void setCoverPrice(float coverPrice) {
		this.coverPrice = coverPrice;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Gibi getGibi() {
		return gibi;
	}

	public void setGibi(Gibi gibi) {
		this.gibi = gibi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edition other = (Edition) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
