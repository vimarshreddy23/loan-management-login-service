package com.loan.management.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.management.login.model.UserDetailsEntity;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserDetailsEntity, Integer> {
	Optional<UserDetailsEntity> findByUserEmail(String userEmail);

	Optional<UserDetailsEntity> findById(Integer id);
}