package com.example.anagrams.utils;

import java.util.Arrays;

public class Anagram {

    public static String reverse(String input, String filter){
        if(filter.equals("")){
            return reverseOnlyLetters(input);
        }
        return reverseExceptChars(input, filter);

    }

    private static String reverseOnlyLetters(String inputString){

        String allLetters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

            String [] inputStringToArray = inputString.split(" ");

            for(int i = 0; i < inputStringToArray.length; i++){
                char [] inputWord = inputStringToArray[i].toCharArray();
                char [] tempArrayForLetters = fillWithSelectedLetters(inputWord, allLetters);
                char [] outputWord = new char[inputWord.length];
                Arrays.fill(outputWord, (char) '\u0000');
                outputWord = fillWithoutSelectedLetters(inputWord, allLetters);
                outputWord = finalFillingOutputArray(tempArrayForLetters, outputWord);
                inputStringToArray[i] = new String(outputWord);
            }

            StringBuilder reversedString = new StringBuilder();
            for (String s : inputStringToArray) {
                reversedString.append(s).append(" ");
            }

            return  reversedString.toString().trim();

        }

    private static String reverseExceptChars(String inputString, String exceptChars){


            String [] inputStringToArray = inputString.split(" ");

            for(int i = 0; i < inputStringToArray.length; i++){
                char [] inputWord = inputStringToArray[i].toCharArray();
                char [] arrayWithoutUsersLetters = fillWithoutSelectedLetters(inputWord, exceptChars);
                char [] outputWord = new char[inputWord.length];
                Arrays.fill(outputWord, (char) '\u0000');
                outputWord = fillWithSelectedLetters(inputWord, exceptChars);
                outputWord = finalFillingOutputArray(arrayWithoutUsersLetters, outputWord);
                inputStringToArray[i] = new String(outputWord);
            }

            StringBuilder reversedString = new StringBuilder();
            for (String s : inputStringToArray) {
                reversedString.append(s).append(" ");
            }

            return  reversedString.toString().trim();

    }

    private static char [] fillWithoutSelectedLetters(char [] inputArray, String exceptLetters){
        char [] withoutSelectedLettersArray = new char[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            if(exceptLetters.indexOf(inputArray[i]) != -1){
                withoutSelectedLettersArray[i] = '\u0000';
            } else {
                withoutSelectedLettersArray[i] = inputArray[i];
            }
        }
        return withoutSelectedLettersArray;
    }

    private static char [] fillWithSelectedLetters(char [] inputArray, String exceptLetters){
        char [] outputArray = new char[inputArray.length];
        for (int i = 0; i < inputArray.length; i++){
            if(exceptLetters.indexOf(inputArray[i]) != -1){
                outputArray[i] = inputArray[i];
            } else {
                outputArray[i] = '\u0000';
            }
        }
        return outputArray;
    }

    private static char [] finalFillingOutputArray(char [] nonUsersLettersArray, char [] outputArray){
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

        return outputArray;
    }


}


