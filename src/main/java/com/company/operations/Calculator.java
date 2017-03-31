package com.company.operations;

/**
 * @author a.dokuchaev on 27.03.2017.
 */
public interface Calculator{
    Number calculate(Number a, Number b, Character operation);
    Number sum(Number a, Number b);
    Number subtract(Number a, Number b);
    Number divide(Number a, Number b);
    Number multiply(Number a, Number b);
}
