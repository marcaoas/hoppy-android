package com.marcaoas.hoppy.presentation.recipes.my;

import com.marcaoas.hoppy.presentation.base.BasePresenter;
import com.marcaoas.hoppy.presentation.recipes.model.RecipeListItem;

import java.util.ArrayList;

/**
 * Created by marco on 26/04/17.
 */

public class MyRecipesPresenter extends BasePresenter<MyRecipesContract.View> {
    public void load() {
        view.showLoading();
        setRecipes();
    }

    private void setRecipes() {
        ArrayList<RecipeListItem> recipes = new ArrayList<>();
        RecipeListItem recipe1 = new RecipeListItem();
        recipe1.title = "Lost in Echo Outmeal";
        recipe1.imageUrl = "http://www.beersmith.com/blog/wp-content/uploads/2008/03/istock_stout_line.jpg";
        recipe1.beerType = "Outmeal stout";
        recipes.add(recipe1);

        RecipeListItem recipe2 = new RecipeListItem();
        recipe2.title = "Lost in Echo Outmeal";
        recipe2.imageUrl = "http://www.beersmith.com/blog/wp-content/uploads/2008/03/istock_stout_line.jpg";
        recipe2.beerType = "Outmeal stout";
        recipes.add(recipe2);

        RecipeListItem recipe3 = new RecipeListItem();
        recipe3.title = "Lost in Echo Outmeal";
        recipe3.imageUrl = "http://www.beersmith.com/blog/wp-content/uploads/2008/03/istock_stout_line.jpg";
        recipe3.beerType = "Outmeal stout";
        recipes.add(recipe3);

        RecipeListItem recipe4 = new RecipeListItem();
        recipe4.title = "Lost in Echo Outmeal";
        recipe4.imageUrl = "http://www.beersmith.com/blog/wp-content/uploads/2008/03/istock_stout_line.jpg";
        recipe4.beerType = "Outmeal stout";
        recipes.add(recipe4);

        view.addRecipes(recipes);
    }


}
