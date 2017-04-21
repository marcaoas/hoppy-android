package com.marcaoas.hoppy.presentation.startup;

import com.marcaoas.hoppy.presentation.base.BaseView;

/**
 * Created by marco on 21/04/17.
 */

public interface StartupContract {
    interface View extends BaseView {
        void goToMain();
        void goToLogin();
    }
}
