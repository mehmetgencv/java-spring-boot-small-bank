package com.mehmetgenc.bank.dao;

import com.mehmetgenc.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByUsername(String username);
}
