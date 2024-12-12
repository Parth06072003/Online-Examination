package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AdminEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {

}
