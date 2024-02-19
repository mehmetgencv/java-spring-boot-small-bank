package com.mehmetgenc.bank.mapper;

import com.mehmetgenc.bank.dto.AccountDto;
import com.mehmetgenc.bank.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto convertToAccountDTO(Account account);

    List<AccountDto> convertToAccountDTOs(List<Account> accounts);

}
