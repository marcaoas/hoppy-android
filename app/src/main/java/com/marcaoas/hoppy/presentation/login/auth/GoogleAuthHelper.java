package com.marcaoas.hoppy.presentation.login.auth;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.presentation.login.LoginActivity;

/**
 * Created by marco on 19/04/17.
 */
public class GoogleAuthHelper {

    private final LoginActivity context;
    private GoogleApiClient mGoogleApiClient;
    private GoogleSignInOptions googleSignInOptions;
    private GoogleSignInResult googleSignInResult;

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

    public Intent getLoginIntent() {
        return Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
    }

    public void setLoginResultData(Intent data) {
        googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
    }

    public boolean isLoginResultSuccess() {
        return googleSignInResult != null && googleSignInResult.isSuccess();
    }

    public String getGoogleIdToken() {
        GoogleSignInAccount account = googleSignInResult.getSignInAccount();
        if(account != null){
            return account.getIdToken();
        }
        return null;
    }
}
