package com.example.anagrams.utils;

import java.util.Arrays;

public class Anagram {

    public static String anagram(String inputString){
    //TODO: make this method a little more readable
        String [] inputArrayString = inputString.split(" ");

        for(int i = 0; i < inputArrayString.length; i++){
            char [] input = inputArrayString[i].toCharArray();
            char [] output = new char[input.length];
            char [] leters = new char[input.length];
            Arrays.fill(output, (char) '\u0000');

            for (int j = 0; j < input.length; j++){
                if(!Character.isLetter(input[j])){
                    output[j] = input[j];
                } else {
                    output[j] = '\u0000';
                }

            }

            for (int j = 0; j < input.length; j++) {
                if(Character.isLetter(input[j])){
                    leters[j] = input[j];
                } else {
                    leters[j] = '\u0000';
                }
            }

            for (int j = 0; j < input.length; j++) {
                if(Character.isLetter(leters[j])) {
                    int counter = 0;
                    boolean isSeted = false;
                    while (!isSeted){
                        if (output[input.length - 1 - counter] == '\u0000'){
                            output[input.length - 1 - counter] = leters[j];
                            isSeted = true;
                        } else {
                            counter++;
                        }

                    }
                }
            }

            inputArrayString[i] = new String(output);
        }

        String str = "";
        for (String s : inputArrayString) {
            str += s + " ";
        }

        return  str.trim();
    }

}
