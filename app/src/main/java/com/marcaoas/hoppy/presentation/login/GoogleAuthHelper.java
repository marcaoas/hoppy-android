package com.marcaoas.hoppy.presentation.login;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.marcaoas.hoppy.R;

/**
 * Created by marco on 19/04/17.
 */

public class GoogleAuthHelper {

    public static final int GOOGLE_LOGIN_REQUEST_CODE = 500;
    private final LoginActivity context;
    private GoogleApiClient mGoogleApiClient;
    private GoogleSignInOptions googleSignInOptions;

    public GoogleAuthHelper(LoginActivity loginActivity) {
        this.context = loginActivity;
    }

    public void configure(Context context) {
        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        initClient();
    }

    private void initClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(context , context)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
    }

    public void login() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        context.startActivityForResult(signInIntent, GOOGLE_LOGIN_REQUEST_CODE);
    }
}
