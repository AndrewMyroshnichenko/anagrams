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

        while ((i < wordToChars.length / 2 || j > wordToChars.length / 2)  && i < wordToChars.length) {
            if(!filter.equals("")) {
                if(filter.indexOf(wordToChars[i]) != -1){
                    i++;
                } else if (filter.indexOf(wordToChars[j]) != -1) {
                    j--;
                } else {
                    char temp = wordToChars[j];
                    wordToChars[j] = wordToChars[i];
                    wordToChars[i] = temp;
                    i++;
                    j--;
                }
            } else {
                if(!Character.isLetter(wordToChars[i])){
                    i++;
                } else if (!Character.isLetter(wordToChars[j])) {
                    j--;
                } else {
                    char temp = wordToChars[j];
                    wordToChars[j] = wordToChars[i];
                    wordToChars[i] = temp;
                    i++;
                    j--;
                }
            }
        }



        return new String(wordToChars);
    }
}


