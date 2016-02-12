package br.com.favoritecollections.gibi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ABOUT")
public class About {	
	
	@Id @GeneratedValue
	@Column(name = "about_id")
	private int id;
	
	@Column(name = "written")
	private String written;
	@Column(name = "art")
	private String art;
	@Column(name = "descrition_history")
	private String descritionHistory;
	@Column(name = "originally_published")
	private int originallyPublished;
	@Column(name = "date_Register", nullable = false)
	private Date dateRegister;
	
	@OneToOne
	@JoinColumn(name = "about_gibi_id", nullable = false)
	private Gibi gibi;
}
