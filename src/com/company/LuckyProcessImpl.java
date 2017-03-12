package com.company;

import java.lang.reflect.Field;

/**
 * Created by user on 07.03.2017.
 */
public class LuckyProcessImpl implements LuckyProcessing{
    @Override
    public double calculate(String expression){
        return 0;
    }

    @Override
    public String generateDecision(){
        Field[] operations = LuckyProcessing.class.getFields();

        for (Field operation : operations){
            System.out.println(operation);
        }
        return null;
    }
}
