package com.app.service;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.Doner;

public interface IDonerServices 
{
	Doner validateUser(String email,String pass);
	List<Doner> listDoners();
	String deleteDoner(int did);
	String registerDoner(Doner d);
	Doner getDonerDetails(int id);
	String updateDoner(Doner d);
}
