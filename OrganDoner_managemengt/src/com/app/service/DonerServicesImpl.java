package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDonerDao;
import com.app.pojos.Admin;
import com.app.pojos.Doner;

@Service 
@Transactional 
public class DonerServicesImpl implements IDonerServices
{
	
	@Autowired
	private IDonerDao dao;

	@Override
	public Doner validateUser(String email, String pass) 
	{
		return dao.validateUser(email, pass);
	}

	@Override
	public List<Doner> listDoners() 
	{
		
		return dao.listDoners();
	}

	@Override
	public String deleteDoner(int did)
	{
		return dao.deleteDonerDetails(dao.getDonerDetails(did));
	}

	@Override
	public String registerDoner(Doner d) 
	{
		return dao.registerDoner(d);
	}

	@Override
	public Doner getDonerDetails(int id) 
	{
		return dao.getDonerDetails(id);
	}

	@Override
	public String updateDoner(Doner d) 
	{
		return dao.updateDonerDetails(d);
	}

	
	
	
	
	

}
