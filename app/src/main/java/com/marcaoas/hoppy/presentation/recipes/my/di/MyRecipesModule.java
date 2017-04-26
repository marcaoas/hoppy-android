package com.marcaoas.hoppy.presentation.recipes.my.di;

import com.marcaoas.hoppy.presentation.di.PerActivity;
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
    public MyRecipesPresenter providesMyRecipesPresenter() {
        return new MyRecipesPresenter();
    }

    @Provides
    @PerActivity
    public MyRecipesAdapter providesMyRecipesAdapter() {
        return new MyRecipesAdapter();
    }

}
