package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ProgramingSubmissionEntity;

public interface ProgramingSubmissionRepo extends JpaRepository<ProgramingSubmissionEntity, Integer> {

}
