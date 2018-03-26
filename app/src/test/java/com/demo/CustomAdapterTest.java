package com.demo;

import android.test.AndroidTestCase;

import com.demo.adapter.CustomAdapter;
import com.demo.model.Row;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by vijayaraj_s on 26/03/18.
 */

public class CustomAdapterTest extends AndroidTestCase {

    /**
     * Member variables declaration
     */
    private Row mRowValue;
    private CustomAdapter mAdapter;
    private ArrayList<Row> mData;

    public CustomAdapterTest() {
        super();
    }

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        // initializing variables
        mData = new ArrayList<>();

        mRowValue = new Row();

        // set dummy data
        mRowValue.setTitle("Beavers");
        mRowValue.setDescription("Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony");
        mRowValue.setImageHref("http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg");

        mData.add(mRowValue);

        mAdapter = new CustomAdapter(getContext(), mData);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * Test the row item id
     *
     * @throws Exception
     */
    @Test
    public void testGetItemId() throws Exception {
        assertEquals("Wrong ID.", 0, mAdapter.getItemId(0));
    }

    /**
     * Test the row item count
     *
     * @throws Exception
     */
    @Test
    public void testGetCount() throws Exception {
        assertEquals("List size is incorrect.", 1, mAdapter.getCount());
    }

    @Test
    public void testObjectManipulation() throws Exception {

        if (mRowValue == null) {
            fail("obj should not be null");
        } else {
            assertEquals(mRowValue.getTitle(), "Beavers");
        }
    }
}
