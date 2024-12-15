package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Exams")
public class ExamEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer examId; 
	@Column(nullable=false)
	String name;
	@Column(nullable=false)
	Integer passing_marks;
	@ManyToOne
	@JoinColumn(name= "adminId",nullable=false)
	AdminEntity adminEntity;
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPassing_marks() {
		return passing_marks;
	}
	public void setPassing_marks(Integer passing_marks) {
		this.passing_marks = passing_marks;
	}
	public AdminEntity getAdminEntity() {
		return adminEntity;
	}
	public void setAdminEntity(AdminEntity adminEntity) {
		this.adminEntity = adminEntity;
	}
	
}
