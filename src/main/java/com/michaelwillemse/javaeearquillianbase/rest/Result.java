package com.michaelwillemse.javaeearquillianbase.rest;

/**
 * Created by Michael on 2/09/2014.
 */
public class Result {
    private String operation;
    private String result;

    public Result() {
    }

    public Result(String operation, String result) {
        this.operation = operation;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
