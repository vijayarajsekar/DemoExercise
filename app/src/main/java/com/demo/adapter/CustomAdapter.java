package com.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.demo.customviews.CustomAdapterView;
import com.demo.model.Row;

import java.util.List;


/**
 * Created by vijayaraj_s on 3/24/2018.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<Row> mRowList;

    public CustomAdapter(Context context, List<Row> rows) {
        this.context = context;
        this.mRowList = rows;
    }

    /**
     *
     * @return List Item Size
     */
    @Override
    public int getCount() {
        return mRowList.size();
    }

    /**
     *
     * @param i Position to get particular item
     * @return Particular item based on position
     */
    @Override
    public Object getItem(int i) {
        return mRowList.get(i);
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (!mRowList.isEmpty()) {
            Row mRow = mRowList.get(position);
            View mView = new CustomAdapterView(context, mRow);

            return mView;

        } else {
            return null;
        }
    }
}
