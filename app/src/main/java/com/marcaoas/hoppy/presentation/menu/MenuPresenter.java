package com.marcaoas.hoppy.presentation.menu;

import com.marcaoas.hoppy.domain.interactors.user.GetCurrentUserInteractor;
import com.marcaoas.hoppy.presentation.base.BasePresenter;
import com.marcaoas.hoppy.presentation.menu.mappers.UserMenuMapper;
import com.marcaoas.hoppy.presentation.menu.models.UserMenu;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by marco on 15/04/17.
 */

public class MenuPresenter extends BasePresenter<MenuContract.View> {

    private final GetCurrentUserInteractor getUser;
    private final UserMenuMapper userMenuMapper;

    public MenuPresenter(GetCurrentUserInteractor getUser, UserMenuMapper userMenuMapper) {
         this.getUser = getUser;
         this.userMenuMapper = userMenuMapper;
    }

    public void loadUser() {
        getUser.execute()
                .map(userMenuMapper::map)
                .observeOn(AndroidSchedulers.mainThread()) //TODO criar um wrapper para as threads
                .subscribe(user -> {
                    view.setUser(user);
                });
    }

}
