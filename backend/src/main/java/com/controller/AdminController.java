package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AdminEntity;
import com.repository.AdminRepo;

@RestController
@RequestMapping("/api/private/admin")
public class AdminController {
	
	@Autowired //Singleton Object (ChatGPT)
	AdminRepo adminRepo;
	
	@PostMapping("/signup")
	public String adminSignup(@RequestBody AdminEntity entity) {
		if(entity!=null)
		{
			System.out.println(entity.getEmail());
			adminRepo.save(entity);
			return "Signup SuccessFully";
		}
		else {
			return "please enter valid details";
		}
	}
	

}
