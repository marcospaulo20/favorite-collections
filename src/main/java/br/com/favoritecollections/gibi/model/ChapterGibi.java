package br.com.favoritecollections.gibi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHAPTER_GIBI)")
public class ChapterGibi {

	@Id @GeneratedValue
	@Column(name = "chapter_gibi_id")
	private int id;	
	
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "story_arc", nullable = false)
	private String storyArc;
	@Column(name = "number_pages")
	private int numberPages;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "chapter_edition_id")
	private Edition edition;
}
