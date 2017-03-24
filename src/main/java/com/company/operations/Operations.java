package com.company.operations;

/**
 * @author a.dokuchaev on 22.03.2017.
 */
public interface Operations{

    Character getOperationById(int id);
    Character getOperationByCharId(char id);
    int size();
}
