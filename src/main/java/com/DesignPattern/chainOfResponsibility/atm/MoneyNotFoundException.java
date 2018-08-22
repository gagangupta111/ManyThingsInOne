package com.DesignPattern.chainOfResponsibility.atm;

public class MoneyNotFoundException extends Exception {

    public MoneyNotFoundException(String message) {
        super(message);
    }
}
