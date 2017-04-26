package com.marcaoas.hoppy.presentation.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.marcaoas.hoppy.domain.interactors.recipe.GetMyRecipesInteractor;
import com.marcaoas.hoppy.domain.interactors.user.GetCurrentUserInteractor;
import com.marcaoas.hoppy.domain.repositories.RecipeRepository;
import com.marcaoas.hoppy.domain.repositories.SettingsRepository;
import com.marcaoas.hoppy.domain.repositories.UserRepository;
import com.marcaoas.hoppy.presentation.HoppyApplication;
import com.marcaoas.hoppy.presentation.Navigator;
import com.marcaoas.hoppy.presentation.di.data.settings.SettingsDataModule;
import com.marcaoas.hoppy.presentation.di.data.user.UserDataModule;
import com.marcaoas.hoppy.presentation.di.data.recipe.RecipeDataModule;

import dagger.Component;

/**
 * Created by marco on 15/04/17.
 */
@Component(modules = { ApplicationModule.class, SettingsDataModule.class, UserDataModule.class, RecipeDataModule.class })
@ApplicationScope
public interface ApplicationComponent {

    void inject(HoppyApplication application);

    @ApplicationContext
    Context applicationContext();
    Navigator navigator();

    UserRepository userRepository();
    RecipeRepository recipeRepository();
    SettingsRepository settingsRepository();
    GetCurrentUserInteractor getCurrentUserInteractor();
}
