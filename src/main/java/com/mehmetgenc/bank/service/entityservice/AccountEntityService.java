package com.mehmetgenc.bank.service.entityservice;

import com.mehmetgenc.bank.dao.AccountRepository;
import com.mehmetgenc.bank.entity.Account;
import com.mehmetgenc.bank.general.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
@Service
public class AccountEntityService extends BaseEntityService<Account, AccountRepository> {

    protected AccountEntityService(AccountRepository repository) {
        super(repository);
    }
}
