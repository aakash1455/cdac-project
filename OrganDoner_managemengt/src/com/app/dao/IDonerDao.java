package com.app.dao;

import java.util.List;

import com.app.pojos.Doner;

public interface IDonerDao 
{
	Doner validateUser(String email,String pass);
	List<Doner> listDoners();
	String deleteDonerDetails(Doner d);
	String updateDonerDetails(Doner d);
	String registerDoner(Doner d);
	Doner getDonerDetails(int vid);
}
