package br.com.favoritecollections.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "sso_id", nullable = false, unique = true)
	private String ssoId;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "e_mail")
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "date_register")
	private Date dateRegister;

}
