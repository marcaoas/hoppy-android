package com.marcaoas.hoppy.presentation.di.data.user;

import com.marcaoas.hoppy.data.mappers.firebase.UserMapper;
import com.marcaoas.hoppy.data.repositories.UserRepositoryImpl;
import com.marcaoas.hoppy.data.stores.firebase.UserDataStore;
import com.marcaoas.hoppy.domain.interactors.user.GetCurrentUserInteractor;
import com.marcaoas.hoppy.domain.repositories.SettingsRepository;
import com.marcaoas.hoppy.domain.repositories.UserRepository;
import com.marcaoas.hoppy.presentation.di.ApplicationScope;
import com.marcaoas.hoppy.presentation.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marco on 18/04/17.
 */
@Module
public class UserDataModule {

    @Provides
    @ApplicationScope
    public UserMapper providesUserMapper() {
        return new UserMapper();
    }

    @Provides
    @ApplicationScope
    public UserDataStore providesUserStore() {
        return new UserDataStore();
    }

    @Provides
    @ApplicationScope
    public UserRepository providesUserRepository(UserDataStore dataStore, UserMapper mapper) {
        return new UserRepositoryImpl(dataStore, mapper);
    }

    @Provides
    @ApplicationScope
    public GetCurrentUserInteractor providesCurrentUser(UserRepository userRepository) {
        return new GetCurrentUserInteractor(userRepository);
    }

}
