package com.marcaoas.hoppy.presentation.login.views;

import android.databinding.BindingAdapter;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.marcaoas.hoppy.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by marco on 21/04/17.
 */

public class LoginButtonViewModel {

    private @StringRes int text;
    private @ColorRes int textColor;
    private @DrawableRes int icon;
    private @DrawableRes int backgroundDrawable;
    private final PublishSubject<LoginButtonViewModel> onClickSubject = PublishSubject.create();

    public LoginButtonViewModel(@StringRes int text, @DrawableRes int icon, @DrawableRes int backgroundDrawable, @ColorRes int textColor) {
        this.text = text;
        this.icon = icon;
        this.backgroundDrawable = backgroundDrawable;
        this.textColor = textColor;
    }

    private void click() {
        onClickSubject.onNext(this);
    }

    public Observable<LoginButtonViewModel> getOnClick() {
        return onClickSubject;
    }

    public @StringRes int getText() {
        return text;
    }

    public void setText(@StringRes int text) {
        this.text = text;
    }

    public @DrawableRes int getIcon() {
        return icon;
    }

    public void setIcon(@DrawableRes int icon) {
        this.icon = icon;
    }

    public @DrawableRes int getBackgroundDrawable() {
        return backgroundDrawable;
    }

    public void setBackgroundDrawable( @DrawableRes int backgroundDrawable) {
        this.backgroundDrawable = backgroundDrawable;
    }

    public @ColorRes int getTextColor() {
        return textColor;
    }

    public void setTextColor(@ColorRes int textColor) {
        this.textColor = textColor;
    }

    public static LoginButtonViewModel facebookButton(){
        return new LoginButtonViewModel(
                R.string.login_with_facebook,
                R.drawable.ic_google_button,
                R.drawable.facebook_button_background,
                R.color.facebook_login_text_color);
    }
    public static LoginButtonViewModel googleButton(){
        return new LoginButtonViewModel(
                R.string.login_with_google,
                R.drawable.ic_google_button,
                R.drawable.google_button_background,
                R.color.google_login_text_color);
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    @BindingAdapter({"android:text"})
    public static void setText(TextView textView, int resource) {
        textView.setText(resource);
    }

    @BindingAdapter({"android:textColor"})
    public static void setTextColor(TextView textView, @ColorRes int resource) {
        textView.setTextColor(textView.getContext().getResources().getColor(resource));
    }

    @BindingAdapter({"android:background"})
    public static void setBackgroundResource(View view, int resource) {
        view.setBackgroundResource(resource);
    }

    @BindingAdapter({"app:buttonOnClick"})
    public static void setClick(View view, LoginButtonViewModel viewModel) {
        view.setOnClickListener(v -> viewModel.click());
    }
}

