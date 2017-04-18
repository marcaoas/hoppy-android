package com.marcaoas.hoppy.presentation.menu.di;

import com.marcaoas.hoppy.data.repositories.UserRepositoryImpl;
import com.marcaoas.hoppy.data.stores.firebase.FirebaseDataStore;
import com.marcaoas.hoppy.data.stores.firebase.UserDataStore;
import com.marcaoas.hoppy.domain.interactors.user.GetCurrentUserInteractor;
import com.marcaoas.hoppy.domain.repositories.SettingsRepository;
import com.marcaoas.hoppy.domain.repositories.UserRepository;
import com.marcaoas.hoppy.presentation.di.PerActivity;
import com.marcaoas.hoppy.presentation.menu.MenuPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marco on 15/04/17.
 */
@Module
public class MenuModule {

    @Provides
    @PerActivity
    public GetCurrentUserInteractor providesGetCurrentUserInteractor(UserRepository userRepository, SettingsRepository settingsRepository) {
        return new GetCurrentUserInteractor(userRepository, settingsRepository);
    }

    @Provides
    @PerActivity
    public MenuPresenter providesMenuPresenter(GetCurrentUserInteractor interactor) {
        return new MenuPresenter(interactor);
    }

}
