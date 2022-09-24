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
    public void basicTest() {
        onView(withId(R.id.editText_input)).perform(ViewActions.typeText("Hello world!"));
        onView(withId(R.id.textView_result)).check(matches(withText("olleH dlrow!")));
    }

    @Test
    public void withFilterTest(){
        onView(withId(R.id.editText_filter)).perform(ViewActions.typeText(("XLxl")));
        onView(withId(R.id.editText_input)).perform(ViewActions.typeText("Foxminded cool 24/7"));
        onView(withId(R.id.textView_result)).check(matches(withText("dexdnimoF oocl 7/42")));
    }

}


