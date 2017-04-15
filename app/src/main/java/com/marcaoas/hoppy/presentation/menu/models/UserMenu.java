package com.marcaoas.hoppy.presentation.menu.models;

/**
 * Created by marco on 15/04/17.
 */

public class UserMenu {

    public String name;
    public String email;
    public String profileImageUrl;

    public UserMenu(String name, String email, String profileImageUrl) {
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
    }

    public UserMenu(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
