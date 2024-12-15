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
@Table(name="SubmissionMCQ")
public class SubmissionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer subId;
	
	@ManyToOne
	@JoinColumn(name= "stdId",nullable=false)
	StudentEntity studentEntity;
	
	@ManyToOne
	@JoinColumn(name= "examId",nullable=false)
	ExamEntity examEntity;
	
	@Column(nullable=false)
	float score;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	Status status;
	
	
}
enum Status{
	Pass,
	Fail
}
