package com.company.generation;

/**
 * @author a.dokuchaev on 13.03.2017.
 */
public class OperationsGenerator implements Generator{

    private int currentValue;
    private int maxCombinationCount;
    private int operationCount;

    public OperationsGenerator(int size, int operationCount){
        if (size > 0){
            this.maxCombinationCount = 4 * (size - 1);
            this.operationCount = operationCount;
        }else{
            maxCombinationCount = 0;
        }
    }

    @Override
    public String next(){
        return Integer.toString(currentValue++, operationCount);
    }

    @Override
    public boolean hasNext(){
        return (currentValue < maxCombinationCount);
    }

    public static void main(String[] args){
        OperationsGenerator generator = new OperationsGenerator(3, 2);

        while (generator.hasNext()){
            System.out.println(generator.next());
        }
    }
}
