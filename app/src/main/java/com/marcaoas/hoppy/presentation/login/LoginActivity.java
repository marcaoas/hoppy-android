package com.marcaoas.hoppy.presentation.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.databinding.ActivityLoginBinding;
import com.marcaoas.hoppy.presentation.base.BaseActivity;
import com.marcaoas.hoppy.presentation.login.di.DaggerLoginComponent;
import com.marcaoas.hoppy.presentation.login.di.LoginModule;

import javax.inject.Inject;

/**
 * Created by marco on 19/04/17.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View, GoogleApiClient.OnConnectionFailedListener {

    private ActivityLoginBinding binding;

    @Inject
    LoginPresenter presenter;

    @Inject
    GoogleAuthHelper googleAuthHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        initializeInjector();
        presenter.initView(this);
        googleAuthHelper.configure(this);
        binding.loginWithGoogleButton.setOnClickListener(view -> presenter.googleLoginClicked());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        presenter.dimiss();
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //TODO refatorar para MVP delegando logica para presenter
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == GoogleAuthHelper.GOOGLE_LOGIN_REQUEST_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                Toast.makeText(this, "Login google success", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Login google Error", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void initializeInjector() {
        DaggerLoginComponent.builder()
                .applicationComponent(getApplicationComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void googleLogin(){
        googleAuthHelper.login();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show(); //TODO fazer tela de loading
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this, "hide loading", Toast.LENGTH_LONG).show(); //TODO fazer tela de loading
    }

    @Override
    public void showError() {
        Toast.makeText(this, "error trying to make loading", Toast.LENGTH_LONG).show(); //TODO fazer tela de erro
    }


    @Override
    public void showInternetError() {
        Toast.makeText(this, "internet connection error", Toast.LENGTH_LONG).show(); //TODO fazer tela de erro
    }

    @Override
    public void goToMain() {
        Toast.makeText(this, "go to main", Toast.LENGTH_LONG).show(); //TODO ir para main
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "google signin error", Toast.LENGTH_LONG).show(); //TODO
    }
}
