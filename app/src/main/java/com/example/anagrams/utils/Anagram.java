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

        if(!filter.equals("")) {
            while (i < wordToChars.length / 2 || j > wordToChars.length / 2) {
                if(filter.indexOf(wordToChars[i]) == -1) {
                        if(filter.indexOf(wordToChars[j]) == -1) {
                            char temp = wordToChars[j];
                            wordToChars[j] = wordToChars[i];
                            wordToChars[i] = temp;
                            i++;
                        }
                            j--;
                } else {
                    if(!Character.isLetter(wordToChars[j])){
                            j--;
                    }
                            i++;
                }
            }
        } else {
            while (i < wordToChars.length / 2 || j > wordToChars.length / 2) {
                if(Character.isLetter(wordToChars[i])){
                        if(Character.isLetter(wordToChars[j])) {
                            char temp = wordToChars[j];
                            wordToChars[j] = wordToChars[i];
                            wordToChars[i] = temp;
                            i++;
                        }
                            j--;
                } else {
                    if(!Character.isLetter(wordToChars[j])){
                            j--;
                    }
                            i++;
                }
            }
        }


        return new String(wordToChars);
    }
}


