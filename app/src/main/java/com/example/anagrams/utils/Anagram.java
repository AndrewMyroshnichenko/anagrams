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

        if(!filter.equals("")) { // if filter is not empty
            for (int i = 0; i < wordToChars.length / 2; i++) {
                if(filter.indexOf(wordToChars[i]) == -1) { //if symbol from the first part is not included in the filter list
                    for(int j = 0; j < wordToChars.length / 2; j++){
                        if(filter.indexOf(wordToChars[wordToChars.length - j - 1]) == -1) { //if symbol from the second part is not included in the filter list
                            char temp = wordToChars[wordToChars.length - i - 1];
                            wordToChars[wordToChars.length - i - 1] = wordToChars[i];
                            wordToChars[i] = temp;
                            break;  // then swap symbols
                        }
                    }

                }
            }
        } else {
            for (int i = 0; i < wordToChars.length / 2; i++) {
                if(Character.isLetter(wordToChars[i])){
                    for(int j = 0; j < wordToChars.length; j++){
                        if(Character.isLetter(wordToChars[wordToChars.length - j - 1])) {
                            char temp = wordToChars[wordToChars.length - i - 1];
                            wordToChars[wordToChars.length - i - 1] = wordToChars[i];
                            wordToChars[i] = temp;
                            break;
                        }
                    }
                }
            }
        }

        return new String(wordToChars);
    }
}


