package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.AdminEntity;
import com.repository.AdminRepo;

public class AdminService {

	@Autowired
	AdminRepo adminRepo;
	
	  public AdminEntity authenticateAdmin(String email,String pass){
		    AdminEntity admin = adminRepo.findByEmail(email);
		    if(admin != null){
		      if(admin.getPassword().equals(pass))
		      {
		    	  return admin;
		      }
		    }
		    return null;
		  }
}
