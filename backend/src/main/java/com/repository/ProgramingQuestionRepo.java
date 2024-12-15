package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ProgramingQuestionEntity;

public interface ProgramingQuestionRepo extends JpaRepository<ProgramingQuestionEntity, Integer> {

}
