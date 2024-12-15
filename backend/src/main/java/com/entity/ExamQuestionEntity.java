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
@Table(name="Exam_Questions")

public class ExamQuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@ManyToOne
	@JoinColumn(name= "examId",nullable=false)
	ExamEntity examEntity;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ExamEntity getExamEntity() {
		return examEntity;
	}

	public void setExamEntity(ExamEntity examEntity) {
		this.examEntity = examEntity;
	}

	public QuestionsEntity getQuestionsEntity() {
		return questionsEntity;
	}

	public void setQuestionsEntity(QuestionsEntity questionsEntity) {
		this.questionsEntity = questionsEntity;
	}

	@ManyToOne
	@JoinColumn(name= "queID",nullable=false)
	QuestionsEntity questionsEntity;
}
