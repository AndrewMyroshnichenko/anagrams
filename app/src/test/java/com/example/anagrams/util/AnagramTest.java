package com.example.anagrams.util;

import com.example.anagrams.utils.Anagram;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void testReverseOnlyLettersIsWorks(){
        Assert.assertEquals("ol1leH dlroW!", Anagram.reverseOnlyLetters("He1llo World!"));
    }

    @Test
    public void testReverseOnlyLettersWhenNull(){
        Assert.assertEquals("Please, write a phrase!", Anagram.reverseOnlyLetters(null));
    }

    @Test
    public void testReverseOnlyLettersFoxmindedInput1(){
        Assert.assertEquals("dednimxoF looc 24/7", Anagram.reverseOnlyLetters("Foxminded cool 24/7"));
    }

    @Test
    public void testReverseOnlyLettersFoxmindedInput2(){
        Assert.assertEquals("dcba hgfe", Anagram.reverseOnlyLetters("abcd efgh"));
    }

    @Test
    public void testReverseOnlyLettersFoxmindedInput3(){
        Assert.assertEquals("d1cba hgf!e", Anagram.reverseOnlyLetters("a1bcd efg!h"));
    }

    @Test
    public void testReverseExceptXLisWorks(){
        Assert.assertEquals("I raew XL trihs-t", Anagram.reverseExceptXL("I wear XL t-shirt"));
    }

    @Test
    public void testReverseExceptXLWhenNull(){
        Assert.assertEquals("Please, write a phrase!", Anagram.reverseExceptXL(null));
    }

    @Test
    public void testReverseExceptXLFoxmindedInput1(){
        Assert.assertEquals("dexdnimoF oocl 7/42", Anagram.reverseExceptXL("Foxminded cool 24/7"));
    }

    @Test
    public void testReverseExceptXLFoxmindedInput2(){
        Assert.assertEquals("dcba hgfe", Anagram.reverseExceptXL("abcd efgh"));
    }

    @Test
    public void testReverseExceptXLFoxmindedInput3(){
        Assert.assertEquals("a1bcd efglh", Anagram.reverseExceptXL("dcb1a hgfle"));
    }


}
