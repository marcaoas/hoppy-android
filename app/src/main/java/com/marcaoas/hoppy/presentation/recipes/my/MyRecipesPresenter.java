package com.marcaoas.hoppy.presentation.recipes.my;

import com.marcaoas.hoppy.domain.interactors.recipe.GetMyRecipesInteractor;
import com.marcaoas.hoppy.presentation.base.BasePresenter;
import com.marcaoas.hoppy.presentation.recipes.mapper.RecipeMapper;
import com.marcaoas.hoppy.presentation.recipes.model.RecipeListItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by marco on 26/04/17.
 */

public class MyRecipesPresenter extends BasePresenter<MyRecipesContract.View> {
    private final GetMyRecipesInteractor getMyRecipes;
    private final RecipeMapper recipeMapper;

    public MyRecipesPresenter(GetMyRecipesInteractor recipesInteractor, RecipeMapper recipeMapper) {
        this.getMyRecipes = recipesInteractor;
        this.recipeMapper = recipeMapper;
    }

    public void load() {
        view.showLoading();
        getMyRecipes.execute()
                .map(recipeMapper::mapRecipeList)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setRecipes, this::showError);
    }

    private void setRecipes(List<RecipeListItem> recipes) {
        view.addRecipes(recipes);
    }

    private void showError(Throwable throwable) {
        view.showError();
    }

    private void setRecipes() {

    }


}
