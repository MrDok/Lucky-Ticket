package com.company.generation;

import com.company.validation.Validation;

/**
 * @author a.dokuchaev on 20.03.2017.
 */
public class PostfixTemplateGenerator implements Generator{

    private static final int MAX_NUMBER_COUNT = 15;
    public static final char REPLACEMENT_OPERATION_SYMBOL = '$';
    private int size;
    private int currentValue;
    private int maxValue;

    /**
     * Generator constructor
     * @param size - count of expression numbers
     */
    public PostfixTemplateGenerator(int size){
        if (size < MAX_NUMBER_COUNT){
            this.size = size;
            maxValue = calculateMaxValue(size);
            currentValue = calculateStartValue(size);
        }
    }

    /**
     * generate next template where 1 symbol is place for number and REPLACEMENT_SYMBOL for operations
     * @return postfix template
     */
    @Override
    public String next(){
        int candidate = getNext(currentValue);

        if (candidate > maxValue){
            throw new IndexOutOfBoundsException();
        }else{
            currentValue = candidate;
            return Integer.toBinaryString(currentValue);//.replace('0', REPLACEMENT_OPERATION_SYMBOL);
        }
    }

    @Override
    public boolean hasNext(){
        if (getNext(currentValue) > maxValue){
            return false;
        }else{
            return true;
        }
    }

    private int getNext(int currentValue){
        do{
            currentValue++;
        }while (currentValue <= maxValue && !Validation.validate(Integer.toBinaryString(currentValue)));

        return currentValue;
    }

    /**
     * Reinitialization of generator
     */
    public void startFromBegin(){
       currentValue = calculateStartValue(this.size);
    }

    /**
     * Calculate least template of postfix expression
     * @param size count of numbers in expression
     * @return template configuration index
     */
    private int calculateStartValue(int size){
        int i = 1;
        for (int j = 0; j < (size - 1); j++){
            i = (i << 2) + 2;
        }

        return i - 1;
    }

    /**
     * calculate max template of postfix expression
     * @param size count of numbers in expression
     * @return template configuration index
     */
    private int calculateMaxValue(int size){
        return ((int)(Math.pow(2, size)) - 1) << size - 1;
    }

    public static void main(String[] args){
        PostfixTemplateGenerator generator = new PostfixTemplateGenerator(3);

        while (generator.hasNext()){
            System.out.println(generator.next());
        }
    }
}
