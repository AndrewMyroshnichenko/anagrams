package com.example.anagrams.utils;

import java.util.Arrays;

public class Anagram {

    public static String reverseOnlyLetters(String inputString){

        if(inputString == null) {
            inputString = "Please, write a phrase!";
        } else {
            String [] inputStringToArray = inputString.split(" ");

            for(int i = 0; i < inputStringToArray.length; i++){
                char [] inputWord = inputStringToArray[i].toCharArray();
                char [] tempArrayForLetters = fillWithLetters(inputWord);
                char [] outputWord = new char[inputWord.length];
                Arrays.fill(outputWord, (char) '\u0000');
                outputWord = fillNonLetters(inputWord);
                outputWord = finalNonLettersReversFilling(tempArrayForLetters, outputWord);
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
                outputWord = finalNonXLLettersReversFilling(tempArrayWithoutXL, outputWord);
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

    public static String reverseUserExceptChars(String inputString, String exceptChars){
        if(inputString == null || exceptChars == null) {
            inputString = "You did not enter a phrase or exclusive characters, please complete both fields.";
        } else {

        }
        return inputString;
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

    private static char [] fillWithLetters(char [] inputArray){
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

    private static char [] finalNonLettersReversFilling(char [] lettersArray, char [] outputArray){
        for (int j = 0; j < outputArray.length; j++) {
            if(lettersArray[j] != '\u0000') {
                int counter = 0;
                boolean charIsSet = false;
                while (!charIsSet){
                    if (outputArray[outputArray.length - 1 - counter] == '\u0000'){
                        outputArray[outputArray.length - 1 - counter] = lettersArray[j];
                        charIsSet = true;
                    } else {
                        counter++;
                    }

                }
            }
        }

        return outputArray;

    }

    private static char [] fillWithoutSelectedLetters(char [] inputArray, String exceptLetters){
        char [] withoutXLArray = new char[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            if(isCharContains(exceptLetters, inputArray[i])){
                withoutXLArray[i] = '\u0000';
            } else {
                withoutXLArray[i] = inputArray[i];
            }
        }
        return withoutXLArray;
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

    private static char [] finalNonXLLettersReversFilling(char [] nonXLLettersArray, char [] outputArray){
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


