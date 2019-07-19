package com.app.service;


import com.app.pojos.Hospital;

public interface IHospitalServices 
{

	Hospital validateHospital(String hospitalName,String password);
}
