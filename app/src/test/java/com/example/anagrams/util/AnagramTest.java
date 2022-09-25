package com.example.anagrams.util;

import com.example.anagrams.utils.Anagram;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void testReverseOnlyLettersIsWorks(){
        Assert.assertEquals("ol1leH dlroW!", Anagram.reverse("He1llo World!", ""));
    }

    @Test
    public void testReverseOnlyLettersFoxmindedInput1(){
        Assert.assertEquals("dednimxoF looc 24/7", Anagram.reverse("Foxminded cool 24/7", ""));
    }

    @Test
    public void testReverseOnlyLettersFoxmindedInput2(){
        Assert.assertEquals("dcba hgfe", Anagram.reverse("abcd efgh", ""));
    }

    @Test
    public void testReverseOnlyLettersFoxmindedInput3(){
        Assert.assertEquals("d1cba hgf!e", Anagram.reverse("a1bcd efg!h", ""));
    }

    @Test
    public void testReverseExceptXLisWorks(){
        Assert.assertEquals("I raew XL trihs-t", Anagram.reverse("I wear XL t-shirt", "XxLl"));
    }

    @Test
    public void testReverseExceptXLFoxmindedInput1(){
        Assert.assertEquals("dexdnimoF oocl 7/42", Anagram.reverse("Foxminded cool 24/7", "XxLl"));
    }

    @Test
    public void testReverseExceptXLFoxmindedInput2(){
        Assert.assertEquals("dcba hgfe", Anagram.reverse("abcd efgh", "XxLl"));
    }

    @Test
    public void testReverseExceptXLFoxmindedInput3(){
        Assert.assertEquals("a1bcd efglh", Anagram.reverse("dcb1a hgfle", "XxLl"));
    }

    @Test
    public void testReverseExceptCharsIsWorks(){
        Assert.assertEquals("Holl1e !dlroW", Anagram.reverse("He1llo World!", "H"));
    }

    //my tests


}
