package com.marcaoas.hoppy.presentation.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by marco on 15/04/17.
 */

public class ImageDownloader {

    @BindingAdapter({"app:imageUrl", "app:imageError", "app:imagePlaceholder"})
    public static void loadImage(ImageView view, String url, Drawable errorImage, Drawable placeholderImage) {
        loadImage(view, url, errorImage, placeholderImage, false);
    }

    @BindingAdapter({"app:imageUrl", "app:imageError", "app:imagePlaceholder", "app:roundedImage"})
    public static void loadImage(ImageView view, String url, Drawable errorImage, Drawable placeholderImage, boolean roundedImage) {
        Glide.with(view.getContext())
                .load(url)
                .bitmapTransform(new CropCircleTransformation(view.getContext()))
                .error(errorImage)
                .placeholder(placeholderImage)
                .into(view);
    }

}
