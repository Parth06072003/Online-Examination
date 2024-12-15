package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.SubmissionEntity;

public interface SubmissionRepo extends JpaRepository<SubmissionEntity, Integer>{

}
