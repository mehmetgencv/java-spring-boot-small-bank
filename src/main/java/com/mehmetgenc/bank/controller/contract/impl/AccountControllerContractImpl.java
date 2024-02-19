package com.mehmetgenc.bank.controller.contract.impl;

import com.mehmetgenc.bank.controller.contract.AccountControllerContract;
import com.mehmetgenc.bank.dto.AccountDto;
import com.mehmetgenc.bank.entity.Account;
import com.mehmetgenc.bank.mapper.AccountMapper;
import com.mehmetgenc.bank.service.entityservice.AccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
@Service
@RequiredArgsConstructor
public class AccountControllerContractImpl implements AccountControllerContract {

    private final AccountEntityService accountEntityService;
    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountEntityService.getAllAccounts();

        return AccountMapper.INSTANCE.convertToAccountDTOs(accounts);
    }
}
