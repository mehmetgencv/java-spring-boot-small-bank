package com.mehmetgenc.bank.service.entityservice;

import com.mehmetgenc.bank.dao.CustomerRepository;
import com.mehmetgenc.bank.entity.Customer;
import com.mehmetgenc.bank.exceptions.ItemNotFoundException;
import com.mehmetgenc.bank.general.BaseEntityService;
import com.mehmetgenc.bank.general.GeneralErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerRepository> {

    protected CustomerEntityService(CustomerRepository repository) {
        super(repository);
    }
    public Customer findCustomerByUsername(String username) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(getRepository().findCustomerByUsername(username));

        Customer customer;
        if(optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
        }else {
            throw new ItemNotFoundException(GeneralErrorMessage.ITEM_NOT_FOUND);
        }
        return customer;
    }
}
