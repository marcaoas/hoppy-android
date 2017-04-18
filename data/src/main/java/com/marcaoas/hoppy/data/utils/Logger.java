package com.marcaoas.hoppy.data.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by marco on 18/04/17.
 */

public class Logger {
    private static final String HOPPY_DATA_TAG = "HOPPY.DATA";

    public static void d(@NonNull String message) {
        if(!TextUtils.isEmpty(message)){
            Log.d(HOPPY_DATA_TAG, message);
        }
    }

    public static void i(@NonNull String message) {
        if(!TextUtils.isEmpty(message)){
            Log.i(HOPPY_DATA_TAG, message);
        }
    }

    public static void e(@NonNull String message) {
        if(!TextUtils.isEmpty(message)){
            Log.e(HOPPY_DATA_TAG, message);
        }
    }

    public static void w(@NonNull String message) {
        if(!TextUtils.isEmpty(message)){
            Log.w(HOPPY_DATA_TAG, message);
        }
    }
}
