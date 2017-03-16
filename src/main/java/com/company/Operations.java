package com.company;

/**
 * Created by user on 07.03.2017.
 */
public enum Operations{
    SUMM("+"),
    SUBTRACTION("-"),
    MULTIPLY("*"),
    DEVISION("/");

    public String operation;

    Operations(String operation){
    }

    public String getOperation(){
        return operation;
    }
}
