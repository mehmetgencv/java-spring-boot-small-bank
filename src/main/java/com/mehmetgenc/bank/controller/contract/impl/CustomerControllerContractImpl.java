package com.mehmetgenc.bank.controller.contract.impl;

import com.mehmetgenc.bank.controller.contract.CustomerControllerContract;
import com.mehmetgenc.bank.dto.CustomerDto;
import com.mehmetgenc.bank.entity.Customer;
import com.mehmetgenc.bank.mapper.CustomerMapper;
import com.mehmetgenc.bank.request.CustomerSaveRequest;
import com.mehmetgenc.bank.request.CustomerUpdateRequest;
import com.mehmetgenc.bank.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerControllerContractImpl implements CustomerControllerContract {
    private final CustomerEntityService customerEntityService;

    @Override
    public CustomerDto updateCustomer(CustomerUpdateRequest request) {

        Customer customer = customerEntityService.findById(request.id());
        CustomerMapper.INSTANCE.updateCustomerFields(customer, request);
        customerEntityService.save(customer);
        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);
        return customerDto;
    }

    @Override
    public CustomerDto saveCustomer(CustomerSaveRequest request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);
        customer = customerEntityService.save(customer);

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);
        return customerDto;

    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customers = customerEntityService.findAll();
        List<CustomerDto> customerDtos = CustomerMapper.INSTANCE.convertToCustomerDtos(customers);
        return customerDtos;
    }
}
