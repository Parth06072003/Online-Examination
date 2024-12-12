package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.StudentEntity;
import com.repository.StudentRepo;

@RestController
@RequestMapping("/api/public/student")
public class StudentController {

	@Autowired
	StudentRepo studentRepo;
	
	
	@GetMapping("/login")
	public String studentLogin(@RequestBody String email,@RequestBody String password)
	{
		if(email == null || email.isEmpty() || password == null || password.isEmpty() )
		{
			return "Please enter the valid details.";
		}
		else
		{
			Optional<StudentEntity> student = studentRepo.findByEmail(email);
			
			if(student.isPresent())
			{
				if(student.get().getPassword().equals(password))
				{
					return "Login Successfully";
				}
				else
				{
					return "Invalid Password";
				}
			}
			else {
				return "Student Not Exist";
			}
		}
	}
}
