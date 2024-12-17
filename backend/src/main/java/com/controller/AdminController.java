package com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//	@PostMapping("/login")
//	public ResponseEntity<?> adminLogin(@RequestBody Map<String,String> reqbody)
//	{
//		HashMap<String ,Object> response = new HashMap<>();
//		
//		String email=reqbody.get("email");
//		String password=reqbody.get("password");
//		String role=reqbody.get("role");
//		
//		Optional<AdminEntity> admin =adminRepo.findByEmail(email);	
//		if(admin.isPresent())
//			{
//				if(admin.get().getPassword().equals(password))
//				{
//					response.put("message", "Login Successfully");
//					return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
//				}
//				else {
//					response.put("error", "Invalid Password");
//					return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
//				}
//			}
//			else
//			{
//				response.put("error", "Admin Not Exist");
//				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
//			}
//		}
//	
	
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

	@PatchMapping ("/updateStudent/{id}")
	public ResponseEntity<?> studentUpdate(@PathVariable("id") Integer id, @RequestBody StudentEntity entity)
	{
		HashMap<String, Object> response =new HashMap<>();
		Optional<StudentEntity> std=studentRepo.findById(id);
		if(std.isPresent()) {
			StudentEntity newstd = std.get();
			if(entity.getFirstname()!=null)
			{
				newstd.setFirstname(entity.getFirstname());
			}
			if(entity.getLastname()!=null)
			{
				newstd.setLastname(entity.getLastname());
			}
			if(entity.getEmail()!=null)
			{
				newstd.setEmail(entity.getEmail());
			}
			if(entity.getPassword()!=null)
			{
				newstd.setPassword(entity.getPassword());
			}
			studentRepo.save(newstd);
			response.put("message", "Student Updated Successfully");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		}
		response.put("error", "Student Not Found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@DeleteMapping("/delete/{id}")	
	public ResponseEntity<?> studentDelete(@PathVariable("id") Integer id)
	{
		HashMap<String, Object> response = new HashMap<>();
		Optional<StudentEntity> std=studentRepo.findById(id);
		if(std.isPresent())
		{
			StudentEntity delstd=std.get();
			studentRepo.delete(delstd);
			response.put("message", "Student Deleted Successfully");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		}
		response.put("error", "Student Not Found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
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
	
	@PatchMapping("/updateQuestion")
	public ResponseEntity<?> updateQuestion(@PathVariable("id") Integer id,@RequestBody QuestionsEntity entity)
	{
		HashMap<String, Object> response = new HashMap<>();
		Optional<QuestionsEntity> que=questionRepo.findById(id);
		if(que.isPresent())
		{
			QuestionsEntity newque =que.get();
			if(entity.getQuestion()!=null)
			{
				newque.setQuestion(entity.getQuestion());
			}
			if(entity.getCategory()!=null)
			{
				newque.setCategory(entity.getCategory());
			}
			if(entity.getOpt1()!=null)
			{
				newque.setOpt1(entity.getOpt1());
			}
			if(entity.getOpt2()!=null)
			{
				newque.setOpt2(entity.getOpt2());
			}
			if(entity.getOpt3()!=null)
			{
				newque.setOpt3(entity.getOpt3());
			}
			if(entity.getOpt4()!=null)
			{
				newque.setOpt4(entity.getOpt4());
			}
			if(entity.getCorrectOpt()!=null)
			{
				newque.setCorrectOpt(entity.getCorrectOpt());
			}
			response.put("message", "Question Updated Successfully");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		}
		response.put("error", "Question Not Found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		
	}


}//End of Admin Controller
