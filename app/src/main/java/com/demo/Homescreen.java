package com.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demo.adapter.ListAdapter;
import com.demo.listeners.ApiCallback;
import com.demo.listeners.AppConstants;
import com.demo.model.Row;
import com.demo.restapicall.ApiClient;
import com.demo.utils.ConnectionManager;
import com.demo.utils.ToastUtils;

import java.util.List;

/**
 * Created by vijayaraj_s on 3/26/2018.
 */


public class Homescreen extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, AppConstants, ApiCallback {

    // Member variable decalration
    private static final String TAG = Homescreen.class.getSimpleName();

    private RecyclerView mListView;
    private SwipeRefreshLayout mSwipeContainer;
    private Context mContext;
    private ListAdapter mItemsAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Row> mListData;

    public static ApiCallback mApiCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        // Initializing member variables
        mContext = this;

        mApiCallback = this;

        mListView = findViewById(R.id.itemsListview);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mListView.setLayoutManager(mLayoutManager);
        mListView.setItemAnimator(new DefaultItemAnimator());

        mSwipeContainer = findViewById(R.id.swiperefresh);
        mSwipeContainer.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light);
        mSwipeContainer.setOnRefreshListener(this);

        // Initial api call to retrieve data
        callApi();

    }

    @Override
    public void onRefresh() {
        callApi();
    }

    /**
     * Set data into list adapter
     */
    private void callApi() {

        if (ConnectionManager.isOnline(mContext)) {

            // Show loading progress
            mSwipeContainer.setRefreshing(true);

            // Requesting api for data
            ApiClient.getData(mApiCallback);

        } else {
            ToastUtils.showToast(mContext, getString(R.string.no_internet_status));
            mSwipeContainer.setRefreshing(false);

            // Checking backup data, if device went offline
            if (null == mListData)
                mListView.setVisibility(View.GONE);
        }
    }

    /**
     * @return Interface instance
     */
    public static ApiCallback getlistener() {
        return mApiCallback;
    }

    @Override
    public void notifylist(List<Row> _data) {

        // Backup data, if device went offline
        mListData = _data;

        // Check the api data and set data into adapter
        if (null != _data) {
            mItemsAdapter = new ListAdapter(mContext,_data);
            mListView.setAdapter(mItemsAdapter);
            mListView.setVisibility(View.VISIBLE);
        } else {
            ToastUtils.showToast(mContext, getString(R.string.no_data_available));
            mListView.setVisibility(View.GONE);
        }

        mSwipeContainer.setRefreshing(false);

    }
}
