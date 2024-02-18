package com.mehmetgenc.bank.general;

import java.time.LocalDateTime;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
public record GeneralErrorMessages(LocalDateTime date, String message, String description) {
}
