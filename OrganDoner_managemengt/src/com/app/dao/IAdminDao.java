package com.app.dao;

import com.app.pojos.Admin;

public interface IAdminDao
{

	Admin validateAdmin(String name,String password);
	
}
