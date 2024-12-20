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
	@Column(nullable=false)
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
	@JoinColumn(name= "adminId",nullable=false)
	AdminEntity adminEntity;

	public Integer getQueId() {
		return queId;
	}

	public void setQueId(Integer queId) {
		this.queId = queId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getOpt4() {
		return opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public Integer getCorrectOpt() {
		return correctOpt;
	}

	public void setCorrectOpt(Integer correctOpt) {
		this.correctOpt = correctOpt;
	}

	public AdminEntity getAdminEntity() {
		return adminEntity;
	}

	public void setAdminEntity(AdminEntity adminEntity) {
		this.adminEntity = adminEntity;
	}
	
}

enum Category{
	Logical,
	Technical,
	Programming
}