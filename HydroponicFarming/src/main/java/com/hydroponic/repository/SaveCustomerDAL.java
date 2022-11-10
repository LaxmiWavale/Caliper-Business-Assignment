package com.hydroponic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hydroponic.model.Customer;

public interface SaveCustomerDAL extends JpaRepository<Customer, String> {

}
