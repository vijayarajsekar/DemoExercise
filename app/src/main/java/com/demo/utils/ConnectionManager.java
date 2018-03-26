package com.demo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by vijayaraj_s on 26/03/18.
 */

public class ConnectionManager {

    /**
     * @param _ctx
     * @return network connectivity status
     */
    public static boolean isOnline(Context _ctx) {
        ConnectivityManager cm = (ConnectivityManager) _ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

}
