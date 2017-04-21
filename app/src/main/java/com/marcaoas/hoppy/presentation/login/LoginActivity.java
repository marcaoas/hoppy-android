package com.marcaoas.hoppy.presentation.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.databinding.ActivityLoginBinding;
import com.marcaoas.hoppy.presentation.base.BaseActivity;
import com.marcaoas.hoppy.presentation.login.di.DaggerLoginComponent;
import com.marcaoas.hoppy.presentation.login.di.LoginModule;
import com.marcaoas.hoppy.presentation.login.views.LoginButtonViewModel;

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
    private LoginButtonViewModel googleButtonViewModel;
    private LoginButtonViewModel facebookButtonViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        initializeInjector();
        presenter.initView(this);
        googleAuthenticator.configure(this);
        setupView();
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

    private void setupView() {
        googleButtonViewModel = LoginButtonViewModel.googleButton();
        googleButtonViewModel.getOnClick().subscribe(button -> presenter.googleLoginClicked());
        binding.setGoogleButtonViewModel(googleButtonViewModel);

        facebookButtonViewModel = LoginButtonViewModel.facebookButton();
        facebookButtonViewModel.getOnClick().subscribe(button -> presenter.facebookLoginClicked());
        binding.setFacebookButtonViewModel(facebookButtonViewModel);
    }

    @Override
    public void googleLogin(){
        startActivityForResult(googleAuthenticator.getLoginIntent(), GOOGLE_LOGIN_REQUEST_CODE);
    }

    @Override
    public void facebookLogin(){
        //TODO
    }

    @Override
    public void showLoading() {
        binding.setIsLoading(true);
    }

    @Override
    public void hideLoading() {
        binding.setIsLoading(false);
    }

    @Override
    public void showError() {
        Snackbar.make(binding.getRoot(), R.string.default_error_message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showGoogleLoginError() {
        Snackbar.make(binding.getRoot(), R.string.login_with_google_error_message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showInternetError() {
        Snackbar.make(binding.getRoot(), R.string.internet_error_message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void goToMain() {
        Toast.makeText(this, "go to main", Toast.LENGTH_LONG).show(); //TODO ir para main
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Snackbar.make(binding.getRoot(), R.string.login_with_google_error_message, Snackbar.LENGTH_LONG).show();
    }
}
