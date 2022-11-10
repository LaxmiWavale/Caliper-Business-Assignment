package com.hydroponic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hydroponic.model.CurrentSession;

public interface LoginDAL extends JpaRepository<CurrentSession, String> {

}
