package com.alves.personalbudget.exceptionhandler;

public class RestError {
    private String userMessage;
    private String developerMessage;
    public RestError(String userMessage, String developerMessage) {
        this.userMessage = userMessage;
        this.developerMessage = developerMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }
}
