package com.demo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by vijayaraj_s on 26/03/18.
 */

public class ToastUtils {

    /**
     * Displaying Toast Message
     *
     * @param _ctx
     * @param _message
     */
    public static void showToast(Context _ctx, String _message) {
        Toast.makeText(_ctx, _message, Toast.LENGTH_LONG).show();
    }
}
