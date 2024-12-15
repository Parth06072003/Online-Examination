package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="Prgm_Submission")
public class ProgramingSubmissionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer subId;
	
	@ManyToOne
	@JoinColumn(name= "stdId",nullable=false)
	StudentEntity studentEntity;
	
	@ManyToOne
	@JoinColumn(name= "queId",nullable=false)
	ProgramingQuestionEntity programingQuestiEntity;
	
	@ManyToOne
	@JoinColumn(name= "examId",nullable=false)
	ExamEntity examEntity;
	
	
	@Column(nullable=false,columnDefinition = "TEXT")
	String code;


	public Integer getSubId() {
		return subId;
	}


	public void setSubId(Integer subId) {
		this.subId = subId;
	}


	public StudentEntity getStudentEntity() {
		return studentEntity;
	}


	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}


	public ProgramingQuestionEntity getProgramingQuestiEntity() {
		return programingQuestiEntity;
	}


	public void setProgramingQuestiEntity(ProgramingQuestionEntity programingQuestiEntity) {
		this.programingQuestiEntity = programingQuestiEntity;
	}


	public ExamEntity getExamEntity() {
		return examEntity;
	}


	public void setExamEntity(ExamEntity examEntity) {
		this.examEntity = examEntity;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	
}