package com.marcaoas.hoppy.presentation.menu;

import com.marcaoas.hoppy.domain.interactors.user.GetCurrentUserInteractor;
import com.marcaoas.hoppy.presentation.base.BasePresenter;
import com.marcaoas.hoppy.presentation.menu.mappers.UserMenuMapper;
import com.marcaoas.hoppy.presentation.menu.models.Menu;
import com.marcaoas.hoppy.presentation.menu.models.UserMenu;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by marco on 15/04/17.
 */

public class MenuPresenter extends BasePresenter<MenuContract.View> {

    private final GetCurrentUserInteractor getUser;
    private final UserMenuMapper userMenuMapper;
    private int itemSelected;

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
                }, error -> {
                    view.setUser(UserMenu.createAnonymousUser());
                });
    }

    public void signInClicked() {
        view.goToLogin();
    }

    public void onItemSelected(int item) {
        view.closeMenu();
        if(this.itemSelected == item) return;
        switch (item) {
            case Menu.NAVIGATION_ITEM_BREW_STEPS:
                view.goToBrewSteps();
            case Menu.NAVIGATION_ITEM_MY_RECIPES:
                view.goToMyRecipes();
            case Menu.NAVIGATION_ITEM_INVENTORY:
                view.goToInventory();
            case Menu.NAVIGATION_ITEM_BREWING_TOOLS:
                view.goToBrewingTools();
            case Menu.NAVIGATION_ITEM_SHOPPING_LIST:
                view.goToShoppingList();
            case Menu.NAVIGATION_ITEM_SETTINGS:
                view.goToSettings();
            case Menu.NAVIGATION_ITEM_LOGOUT:
                view.logout();
        }
        this.itemSelected = item;
    }
}
