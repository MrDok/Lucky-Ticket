package com.company.validation;

/**
 * @author a.dokuchaev on 10.03.2017.
 */
public class Validation{
    public static boolean validate(String binaryNumber){
        short zeroCounts = 0;
        short oneCounts = 0;

        if ('1' == binaryNumber.charAt(0)){
            oneCounts++;
        }else{
            return false;
        }

        for (int i = 1; i < binaryNumber.length(); i++){
            if (binaryNumber.charAt(i) == '1'){
                oneCounts++;
            }else if (binaryNumber.charAt(i) == '0'){
                zeroCounts++;
            }else{
                return false;
            }

            if (oneCounts <= zeroCounts){
                return false;
            }
        }

        return true;
    }
}
