package com.company.generation;

/**
 * @author a.dokuchaev on 13.03.2017.
 */
public interface Generator{

    String next();

    boolean hasNext();

    void startFromBegin();
}
