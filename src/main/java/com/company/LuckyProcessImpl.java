package com.company;

import com.company.generation.Generator;
import com.company.generation.OperationsGenerator;
import com.company.generation.PostfixTemplateGenerator;
import com.company.operations.Operations;
import com.company.operations.SimpleOperations;

import java.util.List;
import java.util.Stack;

/**
 * @author dokuchaev on 07.03.2017.
 */
public class LuckyProcessImpl implements LuckyProcessing{

    private List<String> decisions;
    private Stack<Object> stack;

    private Operations operations;
    private String[] numbers;

    public LuckyProcessImpl(String[] numbers, Operations operations){
        this.numbers = numbers;
        this.operations = operations;
    }

    @Override
    public double calculate(String expression){
        return 0;
    }

    @Override
    public String generateDecision(){
        Generator templateGenerator = new PostfixTemplateGenerator(numbers.length);
        Generator operationsGenerator = new OperationsGenerator(numbers.length - 1, new SimpleOperations());

        while (templateGenerator.hasNext()){
            String template = templateGenerator.next();
            while (operationsGenerator.hasNext()){
                System.out.println(replaceSymbols(template, numbers, operationsGenerator.next()));
            }
        }
        return null;
    }

    private String replaceSymbols(String input, String[] numbers, String operationCombination){
        int numberIndex = numbers.length - 1;
        int operationIndex = 0;

        StringBuilder builder = new StringBuilder(input);

        for (int i = builder.length() - 1; i >= 0 ; i--){
            if (builder.charAt(i) == '0'){
                builder.setCharAt(i, operationCombination.charAt(operationIndex++));
            }else if (builder.charAt(i) == '1'){
                builder.replace(i, i + 1, numbers[numberIndex--]);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args){
        LuckyProcessing luckyProcessing = new LuckyProcessImpl(new String[]{"1", "2", "3"}, new SimpleOperations());

        luckyProcessing.generateDecision();
    }
}
