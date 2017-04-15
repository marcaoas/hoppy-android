package com.marcaoas.hoppy.presentation.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by marco on 15/04/17.
 */

public class ImageDownloader {

    @BindingAdapter({"app:imageUrl", "app:imageError", "app:imagePlaceholder"})
    public static void loadImage(ImageView view, String url, Drawable errorImage, Drawable placeholderImage) {
        Glide.with(view.getContext())
                .load(url)
                .error(errorImage)
                .placeholder(placeholderImage)
                .into(view);
    }

}
