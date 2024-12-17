package com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AdminEntity;
import com.repository.AdminRepo;

@RestController
@RequestMapping("/api/public/session")
public class SessionController {

	@Autowired //Singleton Object (ChatGPT)
	AdminRepo adminRepo;
	
	@PostMapping("/login")
	public ResponseEntity<?> adminLogin(@RequestBody Map<String,String> reqbody)
	{
		HashMap<String ,Object> response = new HashMap<>();
		
		String email=reqbody.get("email");
		String password=reqbody.get("password");
		String role=reqbody.get("role");
		
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
	
}
