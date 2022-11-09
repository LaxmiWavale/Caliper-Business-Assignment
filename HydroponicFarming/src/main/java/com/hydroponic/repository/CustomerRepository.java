package com.hydroponic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hydroponic.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
