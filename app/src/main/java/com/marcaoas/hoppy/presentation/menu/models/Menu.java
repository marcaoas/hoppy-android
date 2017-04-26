package com.marcaoas.hoppy.presentation.menu.models;

import android.support.annotation.IdRes;
import android.support.annotation.IntDef;

import com.marcaoas.hoppy.R;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by marco on 26/04/17.
 */

public class Menu {

    @Retention(SOURCE)
    @IntDef({NAVIGATION_ITEM_BREW_STEPS,
            NAVIGATION_ITEM_MY_RECIPES,
            NAVIGATION_ITEM_INVENTORY,
            NAVIGATION_ITEM_BREWING_TOOLS,
            NAVIGATION_ITEM_SHOPPING_LIST,
            NAVIGATION_ITEM_SETTINGS,
            NAVIGATION_ITEM_LOGOUT})
    public @interface Items {}
    public static final int NAVIGATION_ITEM_BREW_STEPS = 1;
    public static final int NAVIGATION_ITEM_MY_RECIPES = 2;
    public static final int NAVIGATION_ITEM_INVENTORY = 3;
    public static final int NAVIGATION_ITEM_BREWING_TOOLS = 4;
    public static final int NAVIGATION_ITEM_SHOPPING_LIST = 5;
    public static final int NAVIGATION_ITEM_SETTINGS = 6;
    public static final int NAVIGATION_ITEM_LOGOUT = 7;

    public static int getItemFromId(@IdRes int androidId) {
        switch (androidId){
            case R.id.nav_brew_steps:
                return NAVIGATION_ITEM_BREW_STEPS;
            case R.id.nav_my_recipes:
                return NAVIGATION_ITEM_MY_RECIPES;
            case R.id.nav_inventory:
                return NAVIGATION_ITEM_INVENTORY;
            case R.id.nav_brewing_tools:
                return NAVIGATION_ITEM_BREWING_TOOLS;
            case R.id.nav_shopping_list:
                return NAVIGATION_ITEM_SHOPPING_LIST;
            case R.id.nav_settings:
                return NAVIGATION_ITEM_SETTINGS;
            case R.id.nav_logout:
                return NAVIGATION_ITEM_LOGOUT;
        }
        return -1;
    }

}
