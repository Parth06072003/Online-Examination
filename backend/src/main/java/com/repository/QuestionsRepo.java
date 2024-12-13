package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.QuestionsEntity;

public interface QuestionsRepo extends JpaRepository<QuestionsEntity, Integer> {

}
