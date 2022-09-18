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

                if((filter.indexOf(wordToChars[i]) != -1 && !filter.isEmpty() || (!Character.isLetter(wordToChars[i]) && filter.isEmpty()))){
                    i++;
                } else if ((filter.indexOf(wordToChars[j]) != -1 && !filter.isEmpty() || (!Character.isLetter(wordToChars[j]) && filter.isEmpty()))) {
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
}


