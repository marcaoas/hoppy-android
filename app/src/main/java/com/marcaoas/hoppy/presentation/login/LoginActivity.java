package com.marcaoas.hoppy.presentation.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

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

    public static final int GOOGLE_LOGIN_REQUEST_CODE = 500;
    private ActivityLoginBinding binding;

    @Inject
    LoginPresenter presenter;

    @Inject
    GoogleAuthHelper googleAuthenticator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        initializeInjector();
        presenter.initView(this);
        googleAuthenticator.configure(this);
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
        if (requestCode == GOOGLE_LOGIN_REQUEST_CODE) {
            googleAuthenticator.setLoginResultData(data);
            presenter.googleLoginEnded(googleAuthenticator.isLoginResultSuccess(), googleAuthenticator.getGoogleIdToken());
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
        startActivityForResult(googleAuthenticator.getLoginIntent(), GOOGLE_LOGIN_REQUEST_CODE);
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
    public void showGoogleLoginError() {
        Toast.makeText(this, "google login error", Toast.LENGTH_LONG).show(); //TODO google login error
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
