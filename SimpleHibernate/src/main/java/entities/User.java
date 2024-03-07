package entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id	
	@Column (name="UserID")
	int userid;
	
	//if comm may be null 
	//Float comm;
	
	@Column (name="Username")
	String username;
	
	@Column (name="Password")
	String password;
	
	@Column (name="Email")
	String email;
	
	@Column (name="Name")
	String name;
	
	@Column (name="Contact")
	String contact;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email, String name, String contact) {
		super();
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.contact = contact;
	}
	
	
	
	
	
	

}
