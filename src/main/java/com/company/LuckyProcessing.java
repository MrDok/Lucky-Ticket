package com.company;

import java.util.List;

/**
 * @author adokuchaev on 07.03.2017.
 */
public interface LuckyProcessing{
     double calculate(Object[] expression);

     List<String> generateDecisions();

     String infixExpressionView(Object[] expression);
}
