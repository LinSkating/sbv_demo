package com.linskating.springbootvue_demo.exception;

public class ServiceException extends RuntimeException{

    public ServiceException(String msg) {
        super(msg);
    }
}
