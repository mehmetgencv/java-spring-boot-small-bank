package com.mehmetgenc.bank.dto;

import com.mehmetgenc.bank.enums.EnumState;

import java.time.LocalDate;

public record CustomerDto(Long id,
                          String name,
                          String surname,
                          LocalDate birthDate,
                          String username,
                          String identityNo,
                          String phoneNumber,
                          String email,
                          EnumState state) {

}
