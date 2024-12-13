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
@Table(name="Questions")




public class QuestionsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer queId;
	String question;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	Category category;
	
	@Column(nullable=false)
	String opt1;
	
	@Column(nullable=false)
	String opt2;
	
	String opt3;
	String opt4;
	
	@Column(nullable=false)
	Integer correctOpt;
	
	@ManyToOne
	@JoinColumn(name= "adminId")
	AdminEntity adminEntity;
	
}

enum Category{
	Logical,
	Technical,
	Programming
}