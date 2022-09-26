package com.example.anagrams;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AnagramInstrumentalTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void basicTest(){
        String [] filter = {"","","","","XxLl","XxLl","XxLl","XxLl","H"};
        String [] input = {"He1llo World!", "Foxminded cool 24/7", "abcd efgh", "a1bcd efg!h","I wear XL t-shirt", "Foxminded cool 24/7", "abcd efgh", "dcb1a hgfle", "He1llo World!"};
        String[] expectedResult = {"ol1leH dlroW!","dednimxoF looc 24/7","dcba hgfe","d1cba hgf!e","I raew XL trihs-t","dexdnimoF oocl 7/42","dcba hgfe","a1bcd efglh","Holl1e !dlroW"};

        for (int i = 0; i < filter.length; ++i) {
            onView(withId(R.id.editText_filter)).perform(ViewActions.typeText(filter[i]));
            onView(withId(R.id.editText_input)).perform(ViewActions.typeText(input[i]));
            onView(withId(R.id.textView_result)).check(matches(withText(expectedResult[i])));
            onView(withId(R.id.editText_filter)).perform(ViewActions.clearText());
            onView(withId(R.id.editText_input)).perform(ViewActions.clearText());
        }
    }
}


