package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AdminEntity;
import com.entity.StudentEntity;
import com.repository.AdminRepo;
import com.repository.StudentRepo;

@RestController
@RequestMapping("/api/private/admin")
public class AdminController {
	
	@Autowired //Singleton Object (ChatGPT)
	AdminRepo adminRepo;

	
	@PostMapping("/signup")
	public String adminSignup(@RequestBody AdminEntity entity) {
		if(entity!=null)
		{
			adminRepo.save(entity);
			return "Signup SuccessFully";
		}
		else {
			return "please enter valid details";
		}
	}
	@GetMapping("/login")
	public String adminLogin(@RequestBody String email,@RequestBody String password)
	{
		if(email==null || email.isEmpty() || password == null || password.isEmpty())
		{
			return "Please Enter all the Details.";
		}
		else
		{
			Optional<AdminEntity> admin =adminRepo.findByEmail(email);
			
			if(admin.isPresent())
			{
				if(admin.get().getPassword().equals(password))
				{
					return "Login Successfully";
				}
				else {
					return "Invalid Password";
				}
			}
			else
			{
				return "Admin Does not exist";
			}
		}
	}
	
//-----------------------------------------------------------Student Creation Updation Deletation-------------------------------
	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping("/createNewStudent")
	public String studentCreate(@RequestBody StudentEntity entity)
	{
		if(entity!=null)
		{
			studentRepo.save(entity);
			return "Student Added Succesfully";
		}
		return "Please Enter Valid Details"; 
	}
}
