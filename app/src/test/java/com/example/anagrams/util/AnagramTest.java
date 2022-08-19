package com.example.anagrams.util;

import com.example.anagrams.utils.Anagram;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void testAnagramIsWorks(){
        Assert.assertEquals("ol1leH dlroW!", Anagram.reverseOnlyLetters("He1llo World!"));
    }

    @Test
    public void testAngagramWhenNull(){
        Assert.assertEquals("Please, write a phrase!", Anagram.reverseOnlyLetters(null));
    }
}
