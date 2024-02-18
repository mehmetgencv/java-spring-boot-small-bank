package com.mehmetgenc.bank.general;

/**
 * Creation Date: 18.02.2024
 *
 * @author: mehmetgenc
 */
public enum GeneralErrorMessage implements BaseErrorMessage{
    ITEM_NOT_FOUND("Item not found!");

    private final String message;

    GeneralErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
