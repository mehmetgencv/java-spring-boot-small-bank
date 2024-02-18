package com.mehmetgenc.bank.exceptions;

import com.mehmetgenc.bank.general.BaseErrorMessage;
import com.mehmetgenc.bank.general.N11BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends N11BusinessException {
    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
