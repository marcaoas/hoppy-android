package com.marcaoas.hoppy.presentation.menu.models;

/**
 * Created by marco on 15/04/17.
 */

public class UserMenu {

    public String name;
    public String email;
    public String profileImageUrl;
    public boolean isAnonymous;

    public static UserMenu createAnonymousUser() {
        UserMenu userMenu = new UserMenu();
        userMenu.isAnonymous = true;
        return userMenu;
    }
}
