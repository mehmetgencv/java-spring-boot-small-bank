package com.mehmetgenc.bank.general;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 *
 */
@RequiredArgsConstructor
@Getter
@Setter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class N11BusinessException extends RuntimeException {
    private final BaseErrorMessage baseErrorMessage;
}
