package com.mehmetgenc.bank.controller.contract;

import com.mehmetgenc.bank.dto.AccountDto;

import java.util.List;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
public interface AccountControllerContract {
    List<AccountDto> getAllAccounts();
}
