package com.hydroponic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hydroponic.model.CurrentSession;

@Repository
public interface CurrentSessionDAL extends JpaRepository<CurrentSession, String> {

}
