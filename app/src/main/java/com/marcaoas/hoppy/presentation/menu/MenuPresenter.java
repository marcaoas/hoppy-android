package com.marcaoas.hoppy.presentation.menu;

import com.marcaoas.hoppy.domain.interactors.user.GetCurrentUserInteractor;
import com.marcaoas.hoppy.presentation.base.BasePresenter;
import com.marcaoas.hoppy.presentation.menu.models.UserMenu;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by marco on 15/04/17.
 */

public class MenuPresenter extends BasePresenter<MenuContract.View> {

    private final GetCurrentUserInteractor getUser;

    public MenuPresenter(GetCurrentUserInteractor getUser) {
         this.getUser = getUser;
    }

    public void loadUser() {
        getUser.execute().map(user -> {
            //TODO Fazer um mapper
            UserMenu userMenu = new UserMenu();
            userMenu.name = user.getName();
            userMenu.email = user.getEmail();
            userMenu.profileImageUrl = user.getProfileImageUrl();
            return userMenu;
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            view.setUser(user);
        });
    }

}
