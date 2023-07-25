package com.dropwizard.application.exception;

public class ServiceException extends Exception{
    String status;
    public ServiceException(String message,String status){
        super(message);
        this.status=status;
    }

    public String getStatus() {
        return status;
    }
}
