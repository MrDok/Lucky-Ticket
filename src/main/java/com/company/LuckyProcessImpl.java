package com.company;

import com.company.generation.Generator;
import com.company.generation.OperationsGenerator;
import com.company.generation.PostfixTemplateGenerator;
import com.company.operations.Calculator;
import com.company.operations.Operations;
import com.company.operations.SimpleCalculator;
import com.company.operations.SimpleOperations;

import java.util.List;
import java.util.Stack;

/**
 * @author dokuchaev on 07.03.2017.
 */
public class LuckyProcessImpl implements LuckyProcessing{

    private List<String> decisions;

    private Operations operations;
    private String[] numbers;

    public LuckyProcessImpl(String[] numbers, Operations operations){
        this.numbers = numbers;
        this.operations = operations;
    }

    @Override
    public double calculate(Object[] expression){
        Stack<Number> stack = new Stack<>();

        Calculator calculator = new SimpleCalculator();

        for (Object obj : expression){
            if (obj instanceof Number){
                stack.add((Number) obj);
            }else if (obj instanceof Character){
                Number second = stack.pop();
                Number first = stack.pop();

                stack.add(calculator.calculate(first, second, (Character) obj));
            }
        }
        return (float) stack.pop();
    }

    @Override
    public String generateDecision(){
        Generator templateGenerator = new PostfixTemplateGenerator(numbers.length);
        Generator operationsGenerator = new OperationsGenerator(numbers.length - 1, new SimpleOperations());

        while (templateGenerator.hasNext()){
            String template = templateGenerator.next();
            operationsGenerator.startFromBegin();
            while (operationsGenerator.hasNext()){
                String operations = operationsGenerator.next();
                if (operations.equals("//--*")){
                    System.out.println();
                }
                Object[] expression = replaceSymbols(template, numbers, operations);
                if (calculate(expression) == 100f){
                    System.out.println(template + " - " + toStringArray(expression));
                }
            }
        }
        return null;
    }

    private Object[] replaceSymbols(String input, String[] numbers, String operationCombination){
        int numberIndex = 0;
        int operationIndex = 0;

        Object[] expression = new Object[input.length()];

        for (int i = 0; i < input.length() ; i++){
            if (input.charAt(i) == '0'){
                expression[i] = operationCombination.charAt(operationIndex++);
            }else if (input.charAt(i) == '1'){
                expression[i] = Float.parseFloat(numbers[numberIndex++]);
            }
        }

        return expression;
    }

    private String toStringArray(Object[] objects){
        StringBuilder builder = new StringBuilder();

        for (Object object : objects){
            if (object instanceof Number){
                builder.append(String.format("%1$.0f", object) + " ");
            }else{
                builder.append(object.toString() + " ");
            }
        }

        return builder.toString();
    }

    public static void main(String[] args){
        LuckyProcessing luckyProcessing = new LuckyProcessImpl(new String[]{"6", "3", "9", "8", "7", "3"}, new SimpleOperations());

        luckyProcessing.generateDecision();
    }
}
