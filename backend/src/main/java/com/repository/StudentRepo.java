package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer >{
	Optional<StudentEntity> findByEmail(String Email);
}
