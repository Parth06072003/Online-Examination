package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ExamEntity;

public interface ExamRepo extends JpaRepository<ExamEntity, Integer> {

}
