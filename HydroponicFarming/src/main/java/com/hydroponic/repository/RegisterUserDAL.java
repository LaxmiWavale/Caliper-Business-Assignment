package com.hydroponic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hydroponic.model.UserAccountDetails;

@Repository
public interface RegisterUserDAL extends JpaRepository<UserAccountDetails, String> {

}
