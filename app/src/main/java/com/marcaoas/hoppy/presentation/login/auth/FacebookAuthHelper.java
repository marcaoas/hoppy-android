package com.marcaoas.hoppy.presentation.login.auth;

import android.content.Intent;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.presentation.login.LoginActivity;

/**
 * Created by marco on 24/04/17.
 */

public class FacebookAuthHelper implements FacebookCallback<LoginResult> {

    private static final String FACEBOOK_PUBLIC_PROFILE_PERMISSION = "public_profile";
    private static final String FACEBOOK_EMAIL_PERMISSION = "email";
    private final LoginActivity context;
    private CallbackManager mCallbackManager;

    public FacebookAuthHelper(LoginActivity context) {
        this.context = context;
    }

    public void configure(LoginButton loginButton) {
        mCallbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions(FACEBOOK_EMAIL_PERMISSION, FACEBOOK_PUBLIC_PROFILE_PERMISSION);
        loginButton.registerCallback(mCallbackManager, this);
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        AccessToken accessToken = loginResult.getAccessToken();
        if(accessToken != null)
        {
            context.onFacebookLoginSuccess(accessToken.getToken());
        } else {
            context.onFacebookLoginCancelled(true);
        }
    }

    @Override
    public void onCancel() {
        context.onFacebookLoginCancelled(false);
    }

    @Override
    public void onError(FacebookException e) {
        context.onFacebookLoginCancelled(true);
    }

    public void activityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode ,resultCode, data);
    }
}
