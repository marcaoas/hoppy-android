package com.marcaoas.hoppy.presentation.menu;

import com.marcaoas.hoppy.presentation.base.BasePresenter;
import com.marcaoas.hoppy.presentation.menu.models.UserMenu;

/**
 * Created by marco on 15/04/17.
 */

public class MenuPresenter extends BasePresenter<MenuContract.View> {

    public void loadUser() {
        UserMenu user = new UserMenu();
        user.name = "Marco Souza";
        user.email = "marcoasouza.1@gmail.com";
        user.profileImageUrl = "https://robohash.org/hoppy?set=set2";

        view.setUser(user);
    }

}
