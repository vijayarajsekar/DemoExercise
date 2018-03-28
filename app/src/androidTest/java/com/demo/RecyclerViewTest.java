package com.demo;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
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
    public void setUp() throws Exception {

        // For recyclerview setInTouchMode - to avoid crash
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());

        // Get present / relevant activity instance
        getActivity();

    }

    /**
     * Wait for 10 seconds to complete api call
     */

    @Test
    public void testApiCallData() {

        // Wait for 10 sec to load initial data from api
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click on recycler list item positon 1 ( Pre - defined )
        onView(withRecyclerView(R.id.itemsListview).atPosition(1)).perform(click());

    }

    // Checking Recyclerview is valid or not
    @Test
    public void testRecyclerviewisvalid() {
        onView(withId(R.id.itemsListview)).check(matches(isDisplayed()));
    }

    // Scroll recycler list item into position 4 ( Pre - defined )
    @Test
    public void testRecyclerviewScrolltoposition() {
        onView(withId(R.id.itemsListview)).perform(RecyclerViewActions.scrollToPosition(4));
    }
}
