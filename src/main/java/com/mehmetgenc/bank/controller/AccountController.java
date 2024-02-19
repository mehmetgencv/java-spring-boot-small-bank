package com.mehmetgenc.bank.controller;

import com.mehmetgenc.bank.controller.contract.AccountControllerContract;
import com.mehmetgenc.bank.dto.AccountDto;
import com.mehmetgenc.bank.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountControllerContract contract;

    @GetMapping
    public ResponseEntity<RestResponse<List<AccountDto>>> getAllAccounts(){
        List<AccountDto> accountDtos = contract.getAllAccounts();
        return ResponseEntity.ok(RestResponse.of(accountDtos));
    }
}
