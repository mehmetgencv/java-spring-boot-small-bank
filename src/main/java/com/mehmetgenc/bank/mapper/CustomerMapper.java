package com.mehmetgenc.bank.mapper;

import com.mehmetgenc.bank.dto.CustomerDto;
import com.mehmetgenc.bank.entity.Customer;
import com.mehmetgenc.bank.request.CustomerSaveRequest;
import com.mehmetgenc.bank.request.CustomerUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "status", constant = "ACTIVE")
    @Mapping(target = "name", source = "name")
    Customer convertToCustomer(CustomerSaveRequest request);

    CustomerDto convertToCustomerDto(Customer customer);

    List<CustomerDto> convertToCustomerDtos(List<Customer> customers);

    @Mapping(target = "id", ignore = true)
    void updateCustomerFields(@MappingTarget Customer customer, CustomerUpdateRequest request);
}
