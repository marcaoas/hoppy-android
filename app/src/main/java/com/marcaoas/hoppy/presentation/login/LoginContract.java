package com.marcaoas.hoppy.presentation.login;

import com.marcaoas.hoppy.presentation.base.BaseView;

/**
 * Created by marco on 19/04/17.
 */

public interface LoginContract {

    interface View extends BaseView {
        void showLoading();
        void showError();
        void showInternetError();
        void hideLoading();
        void goToMain();
        void googleLogin();
    }

}
