package com.marcaoas.hoppy.presentation.menu.mappers;

import com.marcaoas.hoppy.domain.models.User;
import com.marcaoas.hoppy.presentation.menu.models.UserMenu;

/**
 * Created by marco on 19/04/17.
 */

public class UserMenuMapper {

    public UserMenu map(User user) {
        UserMenu userMenu = new UserMenu();
        userMenu.name = user.getName();
        userMenu.email = user.getEmail();
        userMenu.profileImageUrl = user.getProfileImageUrl();
        userMenu.isAnonymous = user.isAnonymous();
        return userMenu;
    }

}
