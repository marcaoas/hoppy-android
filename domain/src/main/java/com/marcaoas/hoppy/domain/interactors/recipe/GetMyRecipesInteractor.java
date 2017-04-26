package com.marcaoas.hoppy.domain.interactors.recipe;

import com.marcaoas.hoppy.domain.models.Recipe;
import com.marcaoas.hoppy.domain.repositories.RecipeRepository;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by marco on 26/04/17.
 */

public class GetMyRecipesInteractor {

    private final RecipeRepository recipeRepository;

    public GetMyRecipesInteractor(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Flowable<List<Recipe>> execute(){
        return recipeRepository.getMyRecipesList();
    }

}
