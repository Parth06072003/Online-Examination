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
@Table(name="ProgQuestion")
public class ProgramingQuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer queId;
	@Column(columnDefinition = "TEXT",nullable=false)
	String question;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	Category_prgm category;
	@Column(columnDefinition = "TEXT",nullable=false)
	String answer;
	
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

	public Category_prgm getCategory() {
		return category;
	}

	public void setCategory(Category_prgm category) {
		this.category = category;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public AdminEntity getAdminEntity() {
		return adminEntity;
	}

	public void setAdminEntity(AdminEntity adminEntity) {
		this.adminEntity = adminEntity;
	}
}
enum Category_prgm{
	Easy,
	Medium,
	Hard
}