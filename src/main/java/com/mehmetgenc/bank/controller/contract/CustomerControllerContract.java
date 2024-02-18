package com.mehmetgenc.bank.controller.contract;

import com.mehmetgenc.bank.dto.CustomerDto;
import com.mehmetgenc.bank.request.CustomerSaveRequest;
import com.mehmetgenc.bank.request.CustomerUpdatePasswordRequest;
import com.mehmetgenc.bank.request.CustomerUpdateRequest;

import java.util.List;

public interface CustomerControllerContract {
    CustomerDto updateCustomer(CustomerUpdateRequest request);
    CustomerDto saveCustomer(CustomerSaveRequest request);

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long id);

    CustomerDto getCustomerByUsername(String username);

    void deleteCustomer(Long id);

    CustomerDto updateCustomerPassword(Long id, CustomerUpdatePasswordRequest request);
}
