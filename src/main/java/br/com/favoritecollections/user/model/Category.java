package br.com.favoritecollections.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id @GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name ="name", nullable = false)
	private String name;
	@Column(name = "url", nullable = false)
	private String url;
	@Column(name = "date_register", nullable = false)
	private Date dateRegister;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "category_user_id")
	private User user;
		
}