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
import com.entity.StudentEntity;
import com.repository.AdminRepo;
import com.repository.StudentRepo;
import com.service.AdminService;
import com.service.JWTService;

@RestController
@RequestMapping("/api/public/session")
public class SessionController {

	@Autowired //Singleton Object (ChatGPT)
	AdminRepo adminRepo;
	@Autowired
	StudentRepo studRepo;
	@Autowired
	AdminService adminService;
	@Autowired
	JWTService jwtService;

	@PostMapping("/login")
	  public ResponseEntity<?> login(@RequestBody Map<String,String> reqbody) {
		HashMap<String ,Object> response = new HashMap<>();
		
		String email=reqbody.get("email");
		String password=reqbody.get("password");
		String role=reqbody.get("role");
		
	    if (role == null) {
	      return ResponseEntity.badRequest().body("Role not specified");
	    }

	    switch (role.toLowerCase()) {
	      case "admin":
	        AdminEntity admin =adminService.authenticateAdmin(email, password);
	        System.out.println(admin);
	        if (admin != null) {
	          String token = jwtService.generateToken(email, role);
	          System.out.println("Before");
	          System.out.println(token);
	          System.out.println("After");

	          response.put("message", "Login Successful as Admin.");
	          response.put("token", token);
	          response.put("ADMIN", admin);

	          return ResponseEntity.ok()
	              .header("Authorization", "Bearer " + token) // Send token in the response header
	              .body(response);
	        } else {
	          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	        }

	      case "student":
	    	  Optional<StudentEntity> student = studRepo.findByEmail(email);
	    	  if (student != null) {
		          String token = jwtService.generateToken(email, role);
		          System.out.println("Before");
		          System.out.println(token);
		          System.out.println("After");

		          response.put("message", "Login Successful as Student.");
		          response.put("token", token);
		          response.put("Student", student);

		          return ResponseEntity.ok()
		              .header("Authorization", "Bearer " + token) // Send token in the response header
		              .body(response);
		        } else {
		          return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
		        }
	      default:
	        return ResponseEntity.badRequest().body("Invalid Role Specified");
	    }
	  }
}
