package com.marcaoas.hoppy.presentation;

import com.marcaoas.hoppy.presentation.main.MainActivity;

/**
 * Created by marco on 26/04/17.
 */

public class Navigator {

    public void toLogin(){

    }

    public void toMain(){

    }

    public void toBrewSteps(MainActivity mainActivity) {
        mainActivity.goToBrewSteps();
    }

    public void toMyRecipes(MainActivity mainActivity) {
        mainActivity.goToRecipes();
    }

    public void toInventory(MainActivity mainActivity) {
        mainActivity.goToInventory();
    }

    public void toBrewingTools(MainActivity mainActivity) {
        mainActivity.goToBrewingTools();
    }

    public void toShoppingList(MainActivity mainActivity) {
        mainActivity.goToShoppingList();
    }

    public void toSettings(MainActivity mainActivity) {
        mainActivity.goToSettings();
    }

}
