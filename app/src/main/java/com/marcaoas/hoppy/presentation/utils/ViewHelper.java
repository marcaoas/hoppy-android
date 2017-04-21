package com.marcaoas.hoppy.presentation.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.marcaoas.hoppy.presentation.login.LoginContract;

/**
 * Created by marco on 21/04/17.
 */

public class ViewHelper {


    @BindingAdapter({"app:booleanVisibility"})
    public static void setBooleanVisibility(View view, boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

}
