package com.app.service;

import com.app.pojos.Admin;
import com.app.pojos.Doner;

public interface IAdminServices
{
	Admin validateAdmin(String name,String password);

}
