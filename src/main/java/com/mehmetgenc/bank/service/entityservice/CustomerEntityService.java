package com.mehmetgenc.bank.service.entityservice;

import com.mehmetgenc.bank.dao.CustomerRepository;
import com.mehmetgenc.bank.entity.Customer;
import com.mehmetgenc.bank.exceptions.ItemNotFoundException;
import com.mehmetgenc.bank.general.BaseAdditionalFields;
import com.mehmetgenc.bank.general.GeneralErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerEntityService {
    private final CustomerRepository customerRepository;
    public Customer save(Customer customer) {

        BaseAdditionalFields baseAdditionalFields = customer.getBaseAdditionalFields();

        if(baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
        }
        LocalDateTime now = LocalDateTime.now();
        if(customer.getId() == null){
            baseAdditionalFields.setCreateDate(now);
        }
        baseAdditionalFields.setUpdateDate(now);
        customer.setBaseAdditionalFields(baseAdditionalFields);

        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findByIdWithControl(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        Customer customer;
        if(optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
        }else {
            throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
        }
        return customer;
    }

    public Customer findCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
