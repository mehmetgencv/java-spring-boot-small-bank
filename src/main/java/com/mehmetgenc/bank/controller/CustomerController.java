package com.mehmetgenc.bank.controller;

import com.mehmetgenc.bank.controller.contract.CustomerControllerContract;
import com.mehmetgenc.bank.dto.CustomerDto;
import com.mehmetgenc.bank.general.RestResponse;
import com.mehmetgenc.bank.request.CustomerSaveRequest;
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

    @PostMapping()
    public ResponseEntity<RestResponse<CustomerDto>> saveCustomer(@RequestBody CustomerSaveRequest request) {
        CustomerDto customerDto = customerControllerContract.saveCustomer(request);
        return ResponseEntity.ok(RestResponse.of(customerDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<CustomerDto> customerDtos = customerControllerContract.getAll();
        return ResponseEntity.ok(customerDtos);
    }

    @PutMapping("/{debugCustomerId}")
    public CustomerDto updateCustomer(@PathVariable Long debugCustomerId, @RequestBody CustomerUpdateRequest request) {
        return customerControllerContract.updateCustomer(request);

    }
}
