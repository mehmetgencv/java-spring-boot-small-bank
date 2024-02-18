package com.mehmetgenc.bank.controller.contract.impl;

import com.mehmetgenc.bank.controller.contract.CustomerControllerContract;
import com.mehmetgenc.bank.dto.CustomerDto;
import com.mehmetgenc.bank.entity.Customer;
import com.mehmetgenc.bank.errormessage.CustomerErrorMessage;
import com.mehmetgenc.bank.general.N11BusinessException;
import com.mehmetgenc.bank.mapper.CustomerMapper;
import com.mehmetgenc.bank.request.CustomerSaveRequest;
import com.mehmetgenc.bank.request.CustomerUpdatePasswordRequest;
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

        Customer customer = customerEntityService.findByIdWithControl(request.id());
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
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerEntityService.findAll();
        List<CustomerDto> customerDtos = CustomerMapper.INSTANCE.convertToCustomerDtos(customers);
        return customerDtos;
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerEntityService.findByIdWithControl(id);
        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);

        return customerDto;
    }

    @Override
    public CustomerDto getCustomerByUsername(String username) {
        Customer customer = customerEntityService.findCustomerByUsername(username);
        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);
        return customerDto;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerEntityService.deleteCustomer(id);
    }

    @Override
    public CustomerDto updateCustomerPassword(Long id, CustomerUpdatePasswordRequest request) {
        Customer customer = customerEntityService.findByIdWithControl(id);

        if(!customer.getPassword().equals(request.oldPass())){
            throw new N11BusinessException(CustomerErrorMessage.INVALID_OLD_PASSWORD);
        }
        if(!request.newPass().equals(request.newPass2())){
            throw new N11BusinessException(CustomerErrorMessage.NEW_PASSWORDS_DID_NOT_MATCH);
        }
        customer.setPassword(request.newPass());
        customer = customerEntityService.save(customer);

        return CustomerMapper.INSTANCE.convertToCustomerDto(customer);
    }
}
