package com.marcaoas.hoppy.presentation.recipes.my.di;

import com.marcaoas.hoppy.presentation.di.ApplicationComponent;
import com.marcaoas.hoppy.presentation.di.PerActivity;
import com.marcaoas.hoppy.presentation.recipes.my.MyRecipesAdapter;
import com.marcaoas.hoppy.presentation.recipes.my.MyRecipesFragment;
import com.marcaoas.hoppy.presentation.recipes.my.MyRecipesPresenter;

import dagger.Component;

/**
 * Created by marco on 26/04/17.
 */
@Component(modules = MyRecipesModule.class , dependencies = { ApplicationComponent.class })
@PerActivity
public interface MyRecipesComponent {
    void inject(MyRecipesFragment fragment);

    MyRecipesPresenter presenter();
    MyRecipesAdapter adapter();

}
