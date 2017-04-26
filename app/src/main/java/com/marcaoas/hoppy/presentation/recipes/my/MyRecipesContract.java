package com.marcaoas.hoppy.presentation.recipes.my;

import com.marcaoas.hoppy.presentation.base.BaseView;
import com.marcaoas.hoppy.presentation.recipes.model.RecipeListItem;

import java.util.List;

/**
 * Created by marco on 26/04/17.
 */

public interface MyRecipesContract {
    interface View extends BaseView {
        void showLoading();
        void showError();
        void showEmptyList();
        void addRecipes(List<RecipeListItem> recipes);
    }
}
