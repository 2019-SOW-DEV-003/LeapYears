package com.leapyears.view;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import com.leapyears.R;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.leapyears", appContext.getPackageName());
    }

    @Test
    public void shouldReturnLeapYear_When_EnteredLeapYear() {
        inputYear("1996");

        onView(withId(R.id.button_find)).perform(click());

        onView(withId(R.id.txt_result)).check(getViewAssertion(ViewMatchers.Visibility.VISIBLE));
        assertEquals("1996 is a Leap Year", getText((withId(R.id.txt_result))));
    }

    @Test
    public void shouldReturnNotALeapYear_When_EnteredNotALeapYear() {
        inputYear("2003");

        onView(withId(R.id.button_find)).perform(click());

        onView(withId(R.id.txt_result)).check(getViewAssertion(ViewMatchers.Visibility.VISIBLE));
        assertEquals("2003 is not a Leap Year", getText((withId(R.id.txt_result))));
    }

    private void inputYear(String s) {
        onView(withId(R.id.edt_leapyear)).perform(click());
        onView(withId(R.id.edt_leapyear)).perform(typeText(s));
        onView(withId(R.id.edt_leapyear)).perform(closeSoftKeyboard());
    }

    private ViewAssertion getViewAssertion(ViewMatchers.Visibility visible) {
        return matches(ViewMatchers.withEffectiveVisibility(visible));
    }

    String getText(final Matcher<View> matcher) {
        final String[] stringHolder = { null };
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView)view; //Save, because of check in getConstraints()
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }
}