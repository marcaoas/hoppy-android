package com.marcaoas.hoppy.presentation.di;

import android.content.Context;

import com.marcaoas.hoppy.presentation.HoppyApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marco on 15/04/17.
 */
@Module
public class ApplicationModule {

    private final HoppyApplication application;

    public ApplicationModule(HoppyApplication application){
        this.application = application;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    Context providesApplicationContext() {
        return application;
    }

}
