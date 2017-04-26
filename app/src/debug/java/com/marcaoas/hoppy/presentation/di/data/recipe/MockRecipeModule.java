package com.marcaoas.hoppy.presentation.di.data.recipe;

import com.marcaoas.hoppy.domain.repositories.RecipeRepository;
import com.marcaoas.hoppy.presentation.di.ApplicationScope;

import dagger.Provides;

/**
 * Created by marco on 26/04/17.
 */
public class MockRecipeModule{

    @Provides
    @ApplicationScope
    RecipeRepository providesRecipeRepository() {
        return new MockRecipeRepository();
    }
}
