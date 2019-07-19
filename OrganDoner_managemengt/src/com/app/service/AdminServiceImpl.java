package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.dao.IDonerDao;
import com.app.pojos.Admin;

@Service 
@Transactional 
public class AdminServiceImpl implements IAdminServices 
{

	@Autowired
	private IAdminDao dao;
	
	@Override
	public Admin validateAdmin(String name, String password) 
	{
		
		return  dao.validateAdmin(name, password);
	}

}
