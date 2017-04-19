package com.marcaoas.hoppy.presentation.login;

import com.marcaoas.hoppy.presentation.base.BasePresenter;

/**
 * Created by marco on 19/04/17.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> {

    public void googleLoginClicked() {
        view.googleLogin();
    }
}
