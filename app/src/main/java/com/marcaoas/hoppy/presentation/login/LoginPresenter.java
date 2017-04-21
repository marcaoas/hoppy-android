package com.marcaoas.hoppy.presentation.login;

import com.marcaoas.hoppy.domain.interactors.user.DoGoogleLoginInteractor;
import com.marcaoas.hoppy.domain.models.User;
import com.marcaoas.hoppy.presentation.base.BasePresenter;
import com.marcaoas.hoppy.presentation.utils.Logger;

/**
 * Created by marco on 19/04/17.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> {

    private final DoGoogleLoginInteractor doGoogleLogin;

    public LoginPresenter(DoGoogleLoginInteractor doGoogleLogin) {
        this.doGoogleLogin = doGoogleLogin;
    }

    public void googleLoginClicked() {
        view.showLoading();
        view.googleLogin();
    }

    public void googleLoginEnded(boolean successfully, String googleIdToken) {
        if(successfully){
            doGoogleLogin.execute(googleIdToken).subscribe(user -> {
                Logger.d("User: " + user.toString());
                Logger.d("id: " + user.getId());
                Logger.d("name: " + user.getName());
                Logger.d("email: " + user.getEmail());
                Logger.d("avatar: " + user.getProfileImageUrl());
                view.goToMain();
            }, error -> {
                Logger.d("Error: " + error.getLocalizedMessage());
                view.showGoogleLoginError();
            });
        } else {
            view.showGoogleLoginError();
        }
        view.hideLoading();
    }

    public void facebookLoginClicked() {
        view.facebookLogin();
    }
}
