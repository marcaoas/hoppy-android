package com.marcaoas.hoppy.data.repositories;

import com.marcaoas.hoppy.data.stores.system.PreferencesStore;
import com.marcaoas.hoppy.domain.repositories.SettingsRepository;

import io.reactivex.Flowable;

/**
 * Created by marco on 18/04/17.
 */

public class SettingsRepositoryImpl implements SettingsRepository {

    private static final java.lang.String CURRENT_USER_ID = "com.marcaoas.hoppy.data.current_user_id";
    private final PreferencesStore store;

    public SettingsRepositoryImpl(PreferencesStore store) {
        this.store = store;
    }

    @Override
    public Flowable<String> getCurrentUserId() {
        return store.getString(CURRENT_USER_ID);
    }
}
