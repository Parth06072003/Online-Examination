package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ExamQuestionEntity;

public interface ExamQuestionRepo extends JpaRepository<ExamQuestionEntity, Integer> {

}
