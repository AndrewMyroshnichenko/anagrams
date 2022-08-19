package com.example.anagrams.utils;

import java.util.Arrays;

public class Anagram {

    public static String reverseOnlyLetters(String inputString){

        if(inputString == null) {
            inputString = "esaelP, etirw a esarhp!";
        }

        String [] inputStringToArray = inputString.split(" ");

        for(int i = 0; i < inputStringToArray.length; i++){
            char [] inputWord = inputStringToArray[i].toCharArray();
            char [] tempArrayForLetters = fillTempArrayWithLetters(inputWord);
            char [] outputWord = new char[inputWord.length];
            Arrays.fill(outputWord, (char) '\u0000');
            outputWord = fillNonLetters(inputWord);
            outputWord = fillLetters(tempArrayForLetters, outputWord);
            inputStringToArray[i] = new String(outputWord);
        }

        StringBuilder ReversedString = new StringBuilder();
        for (String s : inputStringToArray) {
            ReversedString.append(s).append(" ");
        }

        return  ReversedString.toString().trim();
    }

    private static char [] fillNonLetters(char [] inputArray){
        char [] outputArray = new char[inputArray.length];
        for (int j = 0; j < inputArray.length; j++){
            if(!Character.isLetter(inputArray[j])){
                outputArray[j] = inputArray[j];
            } else {
                outputArray[j] = '\u0000';
            }
        }
        return outputArray;
    }

    private static char [] fillTempArrayWithLetters(char [] inputArray){
        char [] lettersArray = new char[inputArray.length];
        for (int j = 0; j < inputArray.length; j++) {
            if(Character.isLetter(inputArray[j])){
                lettersArray[j] = inputArray[j];
            } else {
                lettersArray[j] = '\u0000';
            }
        }
        return lettersArray;
    }

    private static char [] fillLetters(char [] lettersArray, char [] outputArray){
        for (int j = 0; j < outputArray.length; j++) {
            if(Character.isLetter(lettersArray[j])) {
                int counter = 0;
                boolean isSeted = false;
                while (!isSeted){
                    if (outputArray[outputArray.length - 1 - counter] == '\u0000'){
                        outputArray[outputArray.length - 1 - counter] = lettersArray[j];
                        isSeted = true;
                    } else {
                        counter++;
                    }
                }
            }
        }

        return outputArray;
    }

}
