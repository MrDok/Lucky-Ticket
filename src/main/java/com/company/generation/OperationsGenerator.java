package com.company.generation;

/**
 * @author a.dokuchaev on 13.03.2017.
 */
public class OperationsGenerator implements Generator{

    @Override
    public String next(){
        return null;
    }

    @Override
    public boolean hasNext(){
        return false;
    }

    public static void main(String[] args){
        System.out.println("start");
        for (int i = 0; i < 4096; i++){
            Integer.toString(i, 4);
        }

        System.out.println("finish");
    }
}
