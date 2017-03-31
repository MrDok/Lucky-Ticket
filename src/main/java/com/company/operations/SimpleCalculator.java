package com.company.operations;

/**
 * @author a.dokuchaev on 27.03.2017.
 */
public class SimpleCalculator implements Calculator{
    @Override
    public Number calculate(Number a, Number b, Character operation){
        switch (operation){
            case '+':
                return sum(a, b);

            case '-':
                return subtract(a, b);

            case '/':
                return divide(a, b);

            case '*':
                return multiply(a, b);

            default:
                return null;

        }
    }

    @Override
    public Number sum(Number a, Number b){
        if (a != null && b != null){
            return a.floatValue() + b.floatValue();
        }else{
            throw new IllegalArgumentException("some of inputs is null");
        }
    }

    @Override
    public Number subtract(Number a, Number b){
        if (a != null && b != null){
            return a.floatValue() - b.floatValue();
        }else{
            throw new IllegalArgumentException("some of inputs is null");
        }
    }

    @Override
    public Number divide(Number a, Number b){
        if (a != null && b != null){
            return a.floatValue() / b.floatValue();
        }else{
            throw new IllegalArgumentException("some of inputs is null");
        }
    }

    @Override
    public Number multiply(Number a, Number b){
        if (a != null && b != null){
            return a.floatValue() * b.floatValue();
        }else{
            throw new IllegalArgumentException("some of inputs is null");
        }
    }
}
