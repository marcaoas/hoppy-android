package com.marcaoas.hoppy.presentation.startup.di;

import com.marcaoas.hoppy.domain.interactors.user.GetCurrentUserInteractor;
import com.marcaoas.hoppy.presentation.di.PerActivity;
import com.marcaoas.hoppy.presentation.startup.StartupPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marco on 21/04/17.
 */
@Module
class StartupModule {

    @Provides
    @PerActivity
    public StartupPresenter providesStartupPresenter(GetCurrentUserInteractor currentUserInteractor) {
        return new StartupPresenter(currentUserInteractor);
    }

}
