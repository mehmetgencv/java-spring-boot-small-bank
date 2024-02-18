package com.mehmetgenc.bank.request;


public record CustomerUpdatePasswordRequest(String oldPass, String newPass, String newPass2) {
}
