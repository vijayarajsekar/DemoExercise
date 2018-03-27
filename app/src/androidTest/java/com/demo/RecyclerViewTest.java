package com.demo;

import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.demo.TestUtils.withRecyclerView;

/**
 * Created by vijayaraj_s on 27/03/18.
 */

@RunWith(AndroidJUnit4.class)
public class RecyclerViewTest extends ActivityInstrumentationTestCase2<Homescreen> {

    public RecyclerViewTest() {
        super(Homescreen.class);
    }

    @Before
    protected void setUp() throws Exception {

        getActivity();
    }

    // Checking the widget in Recyclerview
    @Test
    public void testItemClick() {

        onView(withRecyclerView(R.id.itemsListview).atPosition(1)).perform(click());

        onView(withId(R.id.text_title)).check(matches(isDisplayed()));

        onView(withId(R.id.text_description)).check(matches(isDisplayed()));

        onView(withId(R.id.item_image)).check(matches(isDisplayed()));

    }

    // Checking Recyclerview click event
    @Test
    public void testFollowButtonClick() {
        onView(withRecyclerView(R.id.itemsListview).atPositionOnView(0, R.id.text_title)).check(matches(withText("Beavers")));
        onView(withRecyclerView(R.id.itemsListview).atPositionOnView(1, R.id.text_title)).check(matches(withText("Flag")));
    }

}
