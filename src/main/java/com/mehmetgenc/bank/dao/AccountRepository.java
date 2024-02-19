package com.mehmetgenc.bank.dao;

import com.mehmetgenc.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

}
