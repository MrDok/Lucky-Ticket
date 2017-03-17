package com.company;

/**
 * Created by user on 07.03.2017.
 */
public enum Operations{
    SUMM("+", 0),
    SUBTRACTION("-", 1),
    MULTIPLY("*", 2),
    DEVISION("/", 3);

    public String operation;
    private int id;

    Operations(String operation, int id){
        this.operation = operation;
        this.id = id;
    }

    public String getOperation(){
        return operation;
    }

    public int getId(){
        return id;
    }
}
