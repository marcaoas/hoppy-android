package com.marcaoas.hoppy.presentation.startup.di;

import com.marcaoas.hoppy.presentation.di.ApplicationComponent;

import com.marcaoas.hoppy.presentation.di.PerActivity;
import com.marcaoas.hoppy.presentation.startup.StartupActivity;
import com.marcaoas.hoppy.presentation.startup.StartupPresenter;

import dagger.Component;

/**
 * Created by marco on 21/04/17.
 */
@PerActivity
@Component(modules = { StartupModule.class }, dependencies = { ApplicationComponent.class })
public interface StartupComponent {
    StartupPresenter startupPresenter();
    void inject(StartupActivity activity);
}
