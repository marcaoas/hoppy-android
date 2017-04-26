package com.marcaoas.hoppy.presentation.di.data.recipe;

import com.marcaoas.hoppy.domain.repositories.RecipeRepository;
import com.marcaoas.hoppy.presentation.di.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marco on 26/04/17.
 */
@Module
public class RecipeDataModule {

    @Provides
    @ApplicationScope
    RecipeRepository providesRecipeRepository() {
        return new MockRecipeRepository();
    }

}
