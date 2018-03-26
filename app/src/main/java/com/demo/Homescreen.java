package com.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.demo.adapter.CustomAdapter;
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

    private ListView mListView;
    private SwipeRefreshLayout mSwipeContainer;
    private Context mContext;

    public static ApiCallback mApiCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        // Initializing member variables
        mContext = this;

        mApiCallback = this;

        mListView = findViewById(R.id.listview);
        mSwipeContainer = findViewById(R.id.swiperefresh);
        mSwipeContainer.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light);
        mSwipeContainer.setOnRefreshListener(this);

        /**
         * Checking internet connectivity
         */
        if (ConnectionManager.isOnline(mContext)) {
            callApi();
        } else {
            ToastUtils.showToast(mContext, getString(R.string.no_internet_status));
        }

        /**
         * List onItem Click Listener
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
                ToastUtils.showToast(mContext, "Item " + pos + " clicked");
            }
        });
    }

    @Override
    public void onRefresh() {
        callApi();
    }

    /**
     * Set data into list adapter
     */
    private void callApi() {

        // Show loading progress
        mSwipeContainer.setRefreshing(true);

        // Requesting api for data
        ApiClient.getData(mApiCallback);
    }

    /**
     * @return Interface instance
     */
    public static ApiCallback getlistener() {
        return mApiCallback;
    }

    @Override
    public void notifylist(List<Row> _data) {

        if (null != _data)
            mListView.setAdapter(new CustomAdapter(mContext, _data));

        mSwipeContainer.setRefreshing(false);
    }
}
