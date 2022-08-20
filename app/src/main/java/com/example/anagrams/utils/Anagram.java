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
                char [] tempArrayForLetters = fillTempArrayWithLetters(inputWord);
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
        if(inputString == null) {
            inputString = "Please, write a phrase!";
        } else {
            String [] inputStringToArray = inputString.split(" ");

            for(int i = 0; i < inputStringToArray.length; i++){
                char [] inputWord = inputStringToArray[i].toCharArray();
                char [] tempArrayWithoutXL = fillTempArrayWithoutXL(inputWord);
                char [] outputWord = new char[inputWord.length];
                Arrays.fill(outputWord, (char) '\u0000');
                outputWord = fillArrayWithXL(inputWord);
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

    private static char [] fillTempArrayWithoutXL(char [] inputArray){
        char [] withoutXLArray = new char[inputArray.length];
        for (int j = 0; j < inputArray.length; j++) {
            if(inputArray[j] == 'x' || inputArray[j] == 'X' || inputArray[j] == 'l' || inputArray[j] == 'L'){
                withoutXLArray[j] = '\u0000';
            } else {
                withoutXLArray[j] = inputArray[j];
            }
        }
        return withoutXLArray;
    }

    private static char [] fillArrayWithXL(char [] inputArray){
        char [] outputArray = new char[inputArray.length];
        for (int j = 0; j < inputArray.length; j++){
            if(inputArray[j] == 'x' || inputArray[j] == 'X' || inputArray[j] == 'l' || inputArray[j] == 'L'){
                outputArray[j] = inputArray[j];
            } else {
                outputArray[j] = '\u0000';
            }
        }
        return outputArray;
    }

    private static char [] finalNonXLLettersReversFilling(char [] nonXLLettersArray, char [] outputArray){
        for (int j = 0; j < outputArray.length; j++) {
            if(nonXLLettersArray[j] != '\u0000') {
                int counter = 0;
                boolean charIsSet = false;
                while (!charIsSet){
                    if (outputArray[outputArray.length - 1 - counter] == '\u0000'){
                        outputArray[outputArray.length - 1 - counter] = nonXLLettersArray[j];
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
