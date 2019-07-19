package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin 
{
	@Id
	private String name;
	private String password;
	
	public Admin()
	{
		super();
	}

	public Admin(String name, String password)
	{
		super();
		this.name = name;
		this.password = password;
	}

	@Column(length=20)
	public String getName() 
	{
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + "]";
	}
	
	
	
}
