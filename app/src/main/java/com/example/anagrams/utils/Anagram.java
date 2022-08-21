package com.example.anagrams.utils;

import java.util.Arrays;

public class Anagram {

    public static String reverseOnlyLetters(String inputString){

        if(inputString == null) {
            inputString = "Please, write a phrase!";
        } else {
            String [] inputStringToArray = inputString.split(" ");

            String allLetters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

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
        return inputString;


    }

    public static String reverseExceptXL(String inputString){

        String exceptXL = "XxLl";

        if(inputString == null) {
            inputString = "Please, write a phrase!";
        } else {
            String [] inputStringToArray = inputString.split(" ");

            for(int i = 0; i < inputStringToArray.length; i++){
                char [] inputWord = inputStringToArray[i].toCharArray();
                char [] tempArrayWithoutXL = fillWithoutSelectedLetters(inputWord, exceptXL);
                char [] outputWord = new char[inputWord.length];
                Arrays.fill(outputWord, (char) '\u0000');
                outputWord = fillWithSelectedLetters(inputWord, exceptXL);
                outputWord = finalFillingOutputArray(tempArrayWithoutXL, outputWord);
                inputStringToArray[i] = new String(outputWord);
            }

            StringBuilder reversedString = new StringBuilder();
            for (String s : inputStringToArray) {
                reversedString.append(s).append(" ");
            }

            return  reversedString.toString().trim();

        }

        return inputString;
    }

    public static String reverseExceptChars(String inputString, String exceptChars){
        if(inputString == null || exceptChars == null) {
            inputString = "You did not enter a phrase or exclusive characters, please complete both fields.";
        } else {
            String [] inputStringToArray = inputString.split(" ");

            for(int i = 0; i < inputStringToArray.length; i++){
                char [] inputWord = inputStringToArray[i].toCharArray();
                char [] tempArrayWithoutXL = fillWithoutSelectedLetters(inputWord, exceptChars);
                char [] outputWord = new char[inputWord.length];
                Arrays.fill(outputWord, (char) '\u0000');
                outputWord = fillWithSelectedLetters(inputWord, exceptChars);
                outputWord = finalFillingOutputArray(tempArrayWithoutXL, outputWord);
                inputStringToArray[i] = new String(outputWord);
            }

            StringBuilder reversedString = new StringBuilder();
            for (String s : inputStringToArray) {
                reversedString.append(s).append(" ");
            }

            return  reversedString.toString().trim();

        }
        return inputString;
    }

    private static char [] fillWithoutSelectedLetters(char [] inputArray, String exceptLetters){
        char [] withoutSelectedLettersArray = new char[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            if(isCharContains(exceptLetters, inputArray[i])){
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
            if(isCharContains(exceptLetters, inputArray[i])){
                outputArray[i] = inputArray[i];
            } else {
                outputArray[i] = '\u0000';
            }
        }
        return outputArray;
    }

    private static char [] finalFillingOutputArray(char [] nonXLLettersArray, char [] outputArray){
        for (int i = 0; i < outputArray.length; i++) {
            if(nonXLLettersArray[i] != '\u0000') {
                int counter = 0;
                boolean charIsSet = false;
                while (!charIsSet){
                    if (outputArray[outputArray.length - 1 - counter] == '\u0000'){
                        outputArray[outputArray.length - 1 - counter] = nonXLLettersArray[i];
                        charIsSet = true;
                    } else {
                        counter++;
                    }

                }
            }
        }

        return outputArray;
    }

    private static boolean isCharContains(String excludedLetters, char comparableChar){
        char [] inputString = excludedLetters.toCharArray();
        for (char tmp : inputString) {
            if (comparableChar == tmp) {
                return true;
            }
        }
        return false;
    }
}


