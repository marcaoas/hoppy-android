package com.marcaoas.hoppy.presentation.di.data.settings;

import android.content.SharedPreferences;

import com.marcaoas.hoppy.data.repositories.SettingsRepositoryImpl;
import com.marcaoas.hoppy.data.stores.system.PreferencesStore;
import com.marcaoas.hoppy.domain.repositories.SettingsRepository;
import com.marcaoas.hoppy.presentation.di.ApplicationModule;
import com.marcaoas.hoppy.presentation.di.ApplicationScope;


import dagger.Module;
import dagger.Provides;

/**
 * Created by marco on 18/04/17.
 */
@Module(includes = { ApplicationModule.class } )
public class SettingsDataModule {

    @Provides
    @ApplicationScope
    public PreferencesStore providesPreferencesStore(SharedPreferences preferences) {
        return new PreferencesStore(preferences);
    }

    @Provides
    @ApplicationScope
    public SettingsRepository provideSettingsRepository(PreferencesStore preferencesStore) {
        return new SettingsRepositoryImpl(preferencesStore);
    }


}
