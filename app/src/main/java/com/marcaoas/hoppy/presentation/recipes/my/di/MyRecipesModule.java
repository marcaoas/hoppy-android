package com.marcaoas.hoppy.presentation.recipes.my.di;

import com.marcaoas.hoppy.domain.interactors.recipe.GetMyRecipesInteractor;
import com.marcaoas.hoppy.domain.repositories.RecipeRepository;
import com.marcaoas.hoppy.presentation.di.ApplicationScope;
import com.marcaoas.hoppy.presentation.di.PerActivity;
import com.marcaoas.hoppy.presentation.recipes.mapper.RecipeMapper;
import com.marcaoas.hoppy.presentation.recipes.my.MyRecipesAdapter;
import com.marcaoas.hoppy.presentation.recipes.my.MyRecipesPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marco on 26/04/17.
 */
@Module
public class MyRecipesModule {

    @Provides
    @PerActivity
    public MyRecipesPresenter providesMyRecipesPresenter(GetMyRecipesInteractor recipesInteractor, RecipeMapper recipeMapper) {
        return new MyRecipesPresenter(recipesInteractor, recipeMapper);
    }

    @Provides
    @PerActivity
    RecipeMapper providesRecipeMapper() {
        return new RecipeMapper();
    }

    @Provides
    @PerActivity
    GetMyRecipesInteractor providesMyRecipesInteractor(RecipeRepository recipeRepository) {
        return new GetMyRecipesInteractor(recipeRepository);
    }

    @Provides
    @PerActivity
    public MyRecipesAdapter providesMyRecipesAdapter(GetMyRecipesInteractor recipesInteractor) {
        return new MyRecipesAdapter();
    }

}
