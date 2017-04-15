package com.marcaoas.hoppy.presentation.di;

import android.content.Context;

import com.marcaoas.hoppy.presentation.HoppyApplication;

import dagger.Component;

/**
 * Created by marco on 15/04/17.
 */
@Component(modules = ApplicationModule.class)
@ApplicationScope
public interface ApplicationComponent {

    void inject(HoppyApplication application);

    @ApplicationContext
    Context applicationContext();
}
