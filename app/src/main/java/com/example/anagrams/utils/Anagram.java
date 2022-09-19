package com.example.anagrams.utils;

public class Anagram {

    public static String reverse(String inputString, String exceptChars){
        final String [] words = inputString.split("\\s");
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            reversedString.append(reverseWord(word, exceptChars)).append(" ");
        }
            return  reversedString.toString().trim();
    }

    private static String reverseWord (String word, String filter){
        char [] wordToChars = word.toCharArray();
        int i = 0;
        int j = wordToChars.length - 1;

        while (i < j) {

                if(isExceptLetter(wordToChars[i], filter)){
                    i++;
                } else if (isExceptLetter(wordToChars[j], filter)) {
                    j--;
                } else {
                    char temp = wordToChars[j];
                    wordToChars[j] = wordToChars[i];
                    wordToChars[i] = temp;
                    i++;
                    j--;
                }
            }

        return new String(wordToChars);
    }

    private static boolean isExceptLetter(char symbol, String filter){
        if((filter.indexOf(symbol) != -1 || (!Character.isLetter(symbol) && filter.isEmpty()))){
            return true;
        }
        return  false;
    }

}


