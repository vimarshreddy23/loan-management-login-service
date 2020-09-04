package com.scb.lma.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scb.lma.login.model.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

	@Query("select e FROM UserDetails e WHERE e.userEmail =(:userEmail) and e.userPassword=(:userPassword)")
	UserDetails findByuserNameAnduserPassword(@Param("userEmail") String userEmail,
			@Param("userPassword") String userPassword);

}
