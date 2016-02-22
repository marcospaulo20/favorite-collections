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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.favoritecollections.model.Image;

@Entity
@Table(name = "tbgib_edition")
public class Edition {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private Image image;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "edition_chapter",
			joinColumns = {@JoinColumn(name="edition_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="chapter_id", referencedColumnName="id")})
	private List<Chapter> chapters;

	@Column(name = "art", length = 255)
	private String art;
	@Column(name = "editor", length = 255)
	private String editor;
	@Column(name = "number_page", nullable = false)
	private int numberPage;
	@Column(name = "comic_book_format")
	private String comicBookFormat;
	@Column(name = "cover_price", nullable = false)
	private float coverPrice;
	@Column(name = "japan_release")
	private Date japanRelease;
	@Column(name = "brasil_release")
	private Date brasilRelease;
	@Lob
	@Column(name = "summary")
	private byte[] summary;

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

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getNumberPage() {
		return numberPage;
	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
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

	public Date getJapanRelease() {
		return japanRelease;
	}

	public void setJapanRelease(Date japanRelease) {
		this.japanRelease = japanRelease;
	}

	public Date getBrasilRelease() {
		return brasilRelease;
	}

	public void setBrasilRelease(Date brasilRelease) {
		this.brasilRelease = brasilRelease;
	}

	public byte[] getSummary() {
		return summary;
	}

	public void setSummary(byte[] summary) {
		this.summary = summary;
	}
	
}
