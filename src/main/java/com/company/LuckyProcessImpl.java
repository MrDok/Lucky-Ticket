package com.company;

import com.company.generation.Generator;
import com.company.generation.OperationsGenerator;
import com.company.generation.PostfixTemplateGenerator;
import com.company.operations.Calculator;
import com.company.operations.Operations;
import com.company.operations.SimpleCalculator;
import com.company.operations.SimpleOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author dokuchaev on 07.03.2017.
 */
public class LuckyProcessImpl implements LuckyProcessing{

    private Operations operations;
    private String[] numbers;
    private Float expectedResult;

    public LuckyProcessImpl(String[] numbers, Operations operations, Float expectedResult){
        this.numbers = numbers;
        this.operations = operations;
        this.expectedResult = expectedResult;
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
    public String infixExpressionView(Object[] expression){
        Stack<String> stack = new Stack<>();

        for (Object obj : expression){
            if (obj instanceof Number){
                stack.push(String.valueOf(obj));
            }else if (obj instanceof Character){
                String second = stack.pop();
                String first = stack.pop();

                stack.push("(" + first + obj + second + ")");
            }
        }

        return stack.pop();
    }

    @Override
    public List<String> generateDecisions(){
        Generator templateGenerator = new PostfixTemplateGenerator(numbers.length);
        Generator operationsGenerator = new OperationsGenerator(numbers.length - 1, operations);
        List<String> decisions = new ArrayList<>();

        while (templateGenerator.hasNext()){
            String template = templateGenerator.next();
            operationsGenerator.startFromBegin();
            while (operationsGenerator.hasNext()){
                String operations = operationsGenerator.next();

                Object[] expression = replaceSymbols(template, numbers, operations);
                if (calculate(expression) == expectedResult){
                    decisions.add(infixExpressionView(expression));
                }
            }
        }
        return decisions;
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
        LuckyProcessing luckyProcessing = new LuckyProcessImpl(new String[]{"1", "3", "3", "10", "10", "0"}, new SimpleOperations(), 100f);

        List<String> decisions = luckyProcessing.generateDecisions();

        System.out.println("Count of decisions: " + decisions.size());
        for (String decision : decisions){
            System.out.println(decision);
        }
    }
}
