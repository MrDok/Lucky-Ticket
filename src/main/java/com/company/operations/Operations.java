package com.company.operations;

/**
 * @author a.dokuchaev on 22.03.2017.
 */
public interface Operations{

    Character getOperation();
    int getId();
    Character getOperationById(int id);
    int size();
}
