package com.example.anagrams.utils;

import java.util.Arrays;

public class Anagram {

    public static String reverse(String inputString, String exceptChars){


            final String [] tempArray = inputString.split("\\s");
            return  buildReversedArray(tempArray, exceptChars);

    }

    private static char [] fillWithoutSelectedLetters(char [] inputArray, String exceptLetters){
        char [] withoutSelectedLettersArray = new char[inputArray.length];

        if(!exceptLetters.equals("")) {
            for (int i = 0; i < inputArray.length; i++) {
                if(exceptLetters.indexOf(inputArray[i]) != -1){
                    withoutSelectedLettersArray[i] = '\u0000';
                } else {
                    withoutSelectedLettersArray[i] = inputArray[i];
                }
            }
        } else {
            for (int i = 0; i < inputArray.length; i++) {
                if (!Character.isLetter(inputArray[i])) {
                    withoutSelectedLettersArray[i] = '\u0000';
                } else {
                    withoutSelectedLettersArray[i] = inputArray[i];
                }
            }
        }

        return withoutSelectedLettersArray;
    }

    private static char [] fillWithSelectedLetters(char [] inputArray, String exceptLetters){
        char [] outputArray = new char[inputArray.length];

        if(!exceptLetters.equals("")) {
            for (int i = 0; i < inputArray.length; i++){
                if(exceptLetters.indexOf(inputArray[i]) != -1){
                    outputArray[i] = inputArray[i];
                } else {
                    outputArray[i] = '\u0000';
                }
            }
        } else {
            for (int i = 0; i < inputArray.length; i++) {
                if (!Character.isLetter(inputArray[i])) {
                    outputArray[i] = inputArray[i];
                } else {
                    outputArray[i] = '\u0000';
                }
            }
        }


        return outputArray;
    }

    private static void finalFillingOutputArray(char [] nonUsersLettersArray, char [] outputArray){
        for (int i = 0; i < outputArray.length; i++) {
            if(nonUsersLettersArray[i] != '\u0000') {
                int counter = 0;
                boolean charIsSet = false;
                while (!charIsSet){
                    if (outputArray[outputArray.length - 1 - counter] == '\u0000'){
                        outputArray[outputArray.length - 1 - counter] = nonUsersLettersArray[i];
                        charIsSet = true;
                    } else {
                        counter++;
                    }

                }
            }
        }

    }

    private static String buildReversedArray(String [] stringToStringsArray, String exceptChars){

        StringBuilder reversedString = new StringBuilder();

        for(int i = 0; i < stringToStringsArray.length; i++){
            char [] inputWord = stringToStringsArray[i].toCharArray();
            char [] arrayWithoutUsersLetters = fillWithoutSelectedLetters(inputWord, exceptChars);
            char [] outputWord = new char[inputWord.length];
            Arrays.fill(outputWord, (char) '\u0000');
            outputWord = fillWithSelectedLetters(inputWord, exceptChars);
            finalFillingOutputArray(arrayWithoutUsersLetters, outputWord);
            reversedString.append(outputWord).append(" ");
        }

        return reversedString.toString().trim();
    }


}


