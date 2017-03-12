package com.company;

public class Main {

    public static void main(String[] args) {
        int start = 0b11000011110;
        int i = 0, j = 0;

        while(start < 0b11111100000){
            start += 0b10;

            String expression = Integer.toBinaryString(start);
            if (expression.replaceAll("0", "").length() ==6 ){
                System.out.println(expression);
                j++;
            }
            i++;
        }
        System.out.println("All: " + i + "\nWhat need: "+ j);
        System.out.println((((float) j)/i)*100);
    }
}
