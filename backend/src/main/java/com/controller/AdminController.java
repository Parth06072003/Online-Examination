package com.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AdminEntity;
import com.entity.QuestionsEntity;
import com.entity.StudentEntity;
import com.repository.AdminRepo;
import com.repository.QuestionsRepo;
import com.repository.StudentRepo;

@RestController
@RequestMapping("/api/private/admin")
public class AdminController {
	
	@Autowired //Singleton Object (ChatGPT)
	AdminRepo adminRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	QuestionsRepo questionRepo;
	
	@PostMapping("/signup")
	public ResponseEntity<?> adminSignup(@RequestBody AdminEntity entity) {
		HashMap<String , Object> response = new HashMap<>();
		if(entity!=null)
		{
			adminRepo.save(entity);
			response.put("message", "Signup Successfully");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		else {
			response.put("error", "Signup Failed");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	@GetMapping("/login")
	public ResponseEntity<?> adminLogin(@RequestBody String email,@RequestBody String password)
	{
		HashMap<String ,Object> response = new HashMap<>();
		Optional<AdminEntity> admin =adminRepo.findByEmail(email);	
		if(admin.isPresent())
			{
				if(admin.get().getPassword().equals(password))
				{
					response.put("message", "Login Successfully");
					return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
				}
				else {
					response.put("error", "Invalid Password");
					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
				}
			}
			else
			{
				response.put("error", "Admin Not Exist");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
			}
		}
	
	
//-----------------------------------------------------------Student Creation Updation Deletation-------------------------------

	
	@PostMapping("/createNewStudent")
	public ResponseEntity<?> studentCreate(@RequestBody StudentEntity entity)
	{
		HashMap<String, Object> response =new HashMap<>();
		if(entity!=null)
		{
			studentRepo.save(entity);
			response.put("message", "Student Added Successfully");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		response.put("message", "Error in Adding Student");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); 
	}


//------------------------------------------------------------Questions CRUD-------------------------------------------------------



@PostMapping("/createQuestions")
public ResponseEntity<?> createQuestion(@RequestBody QuestionsEntity entity)
{
	HashMap<String,Object> response = new HashMap<>();
	if(entity!= null)
	{
		questionRepo.save(entity);
		response.put("message", "Question Added Successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	else
	{
		response.put("error", "Error in Adding Question");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
}
