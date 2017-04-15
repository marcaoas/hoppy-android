package com.marcaoas.hoppy.presentation.menu;

import com.marcaoas.hoppy.presentation.base.BaseView;
import com.marcaoas.hoppy.presentation.menu.models.UserMenu;

/**
 * Created by marco on 15/04/17.
 */

public interface MenuContract {

    interface View extends BaseView {
        void setUser(UserMenu user);
    }

}
