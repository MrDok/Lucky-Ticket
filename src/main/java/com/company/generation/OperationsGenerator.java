package com.company.generation;

import com.company.operations.Operations;
import com.company.operations.SimpleOperations;

/**
 * @author a.dokuchaev on 13.03.2017.
 */
public class OperationsGenerator implements Generator{

    private int currentValue;
    private int maxCombinationCount;
    private int operationCount;
    private Operations operations;
    private String template;

    public OperationsGenerator(int size, Operations operations){
        if (size > 0){
            this.maxCombinationCount = (int) Math.pow(operations.size(), size);
            this.operationCount = operations.size();
            this.operations = operations;
            this.template = generateTemplate(size);
        }else{
            maxCombinationCount = 0;
        }
    }

    @Override
    public String next(){
        return replaceSymbolsToOperations(String.format(template, Integer.parseInt(Integer.toString(currentValue++, operationCount))));
    }

    @Override
    public boolean hasNext(){
        return (currentValue < maxCombinationCount);
    }

    private String replaceSymbolsToOperations(String input){
        if (input != null){
            StringBuilder builder = new StringBuilder();
            for (char ch : input.toCharArray()){
                builder.append(operations.getOperationByCharId(ch));
            }

            return builder.toString();
        }else{
            return null;
        }
    }

    private String generateTemplate(int size){
        return "%0" + size + "d";
    }

    @Override
    public void startFromBegin(){
        currentValue = 0;
    }

    public static void main(String[] args){
        OperationsGenerator generator = new OperationsGenerator(2, new SimpleOperations());
        while (generator.hasNext()){
            System.out.println(generator.next());
        }
    }
}
