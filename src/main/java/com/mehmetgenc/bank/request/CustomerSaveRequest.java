package com.mehmetgenc.bank.request;

import java.time.LocalDate;

public record CustomerSaveRequest(String name,
                                  String surname,
                                  LocalDate birthDate,
                                  String username,
                                  String identityNo,
                                  String password,
                                  String phoneNumber,
                                  String email) {

}
