package com.marcaoas.hoppy.presentation.recipes.mapper;

import com.marcaoas.hoppy.domain.models.Recipe;
import com.marcaoas.hoppy.presentation.recipes.model.RecipeListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 26/04/17.
 */

public class RecipeMapper {

    public RecipeListItem mapRecipeList(Recipe recipe){
        if(recipe == null) return null;
        RecipeListItem recipeItem = new RecipeListItem();
        recipeItem.title = recipe.getTitle();
        recipeItem.imageUrl = recipe.getImageUrl();
        recipeItem.beerType = recipe.getBeerType();
        recipeItem.id = recipe.getId();
        return recipeItem;
    }

    public List<RecipeListItem> mapRecipeList(List<Recipe> recipes) {
        if(recipes == null) return null;
        ArrayList<RecipeListItem> recipesList = new ArrayList<>();
        for(Recipe recipe : recipes){
            recipesList.add(mapRecipeList(recipe));
        }
        return recipesList;
    }

}
