package com.stockify.stocksearch.exception;

import com.stockify.stocksearch.controllers.ExceptionProperties;

public class StockifyException extends Exception {
    private final ExceptionProperties type;
    public StockifyException(String message, ExceptionProperties inType){
        super(message);
        type= inType;
    }

    public ExceptionProperties getType() {
        return type;
    }
}
