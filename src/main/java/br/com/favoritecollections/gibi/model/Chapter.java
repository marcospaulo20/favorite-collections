package br.com.favoritecollections.gibi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbgib_chapter")
public class Chapter {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name_saga", length = 255, nullable = false)
	private String nameSaga;
	@Column(name = "name_bow", length = 255, nullable = false)
	private String nameBow;

	public Chapter() {
	}

	public int getId() {
		return id;
	}

	public String getNameSaga() {
		return nameSaga;
	}

	public void setNameSaga(String nameSaga) {
		this.nameSaga = nameSaga;
	}

	public String getNameBow() {
		return nameBow;
	}

	public void setNameBow(String nameBow) {
		this.nameBow = nameBow;
	}

}
