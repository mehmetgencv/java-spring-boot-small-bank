package com.mehmetgenc.bank.dao;

import com.mehmetgenc.bank.entity.Customer;
import com.mehmetgenc.bank.enums.EnumStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByUsername(String username);

    List<Customer> findAllByNameAndSurnameAndStatus(String name, String surname, EnumStatus status);

    Customer findByNameAndSurnameAndStatus(String name, String surname, EnumStatus status);

    @Query("select c from Customer c left join Account a on c.id = a.id ")
    Customer findByUsernameWithAccount();
}
