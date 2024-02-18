package com.mehmetgenc.bank.controller;

import com.mehmetgenc.bank.controller.contract.CustomerControllerContract;
import com.mehmetgenc.bank.dto.CustomerDto;
import com.mehmetgenc.bank.general.RestResponse;
import com.mehmetgenc.bank.request.CustomerSaveRequest;
import com.mehmetgenc.bank.request.CustomerUpdatePasswordRequest;
import com.mehmetgenc.bank.request.CustomerUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private CustomerControllerContract customerControllerContract;

    public CustomerController(CustomerControllerContract customerControllerContract) {
        this.customerControllerContract = customerControllerContract;
    }


    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDto>>> getAllCustomers() {
        List<CustomerDto> customerDtos = customerControllerContract.getAllCustomers();
        return ResponseEntity.ok(RestResponse.of(customerDtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerDto>> getCustomerById(@PathVariable Long id){
        CustomerDto customerDto = customerControllerContract.getCustomerById(id);
        return ResponseEntity.ok(RestResponse.of(customerDto));
    }

    @GetMapping("/with-username/{username}")
    public ResponseEntity<RestResponse<CustomerDto>> getCustomerByUsername(@PathVariable String username) {
        CustomerDto customerById = customerControllerContract.getCustomerByUsername(username);
        return ResponseEntity.ok(RestResponse.of(customerById));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CustomerDto>> saveCustomer(@RequestBody CustomerSaveRequest request) {
        CustomerDto customerDto = customerControllerContract.saveCustomer(request);
        return ResponseEntity.ok(RestResponse.of(customerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> deleteCustomer(@PathVariable Long id){
        customerControllerContract.deleteCustomer(id);
        return ResponseEntity.ok(RestResponse.of("Deleted") );
    }

    @PutMapping("/{debugCustomerId}")
    public ResponseEntity<RestResponse<CustomerDto>> updateCustomer(@PathVariable Long debugCustomerId, @RequestBody CustomerUpdateRequest request) {
        CustomerDto customerDto = customerControllerContract.updateCustomer(request);
        return ResponseEntity.ok(RestResponse.of(customerDto));

    }
    @PatchMapping("/{id}/password")
    public CustomerDto updateCustomerPassword(@PathVariable Long id, @RequestBody CustomerUpdatePasswordRequest request) {
        return customerControllerContract.updateCustomerPassword(id, request);
    }
}
