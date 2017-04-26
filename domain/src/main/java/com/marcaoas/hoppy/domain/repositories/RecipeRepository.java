package com.marcaoas.hoppy.domain.repositories;

import com.marcaoas.hoppy.domain.models.Recipe;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by marco on 26/04/17.
 */

public interface RecipeRepository {

    Flowable<List<Recipe>> getMyRecipesList();

}
