package com.marcaoas.hoppy.presentation;

import android.app.Application;
import android.content.Context;

import com.marcaoas.hoppy.presentation.di.ApplicationComponent;
import com.marcaoas.hoppy.presentation.di.ApplicationContext;
import com.marcaoas.hoppy.presentation.di.ApplicationModule;
import com.marcaoas.hoppy.presentation.di.DaggerApplicationComponent;

/**
 * Created by marco on 15/04/17.
 */

public class HoppyApplication extends Application {

    public static HoppyApplication get(Context context) {
        return (HoppyApplication) context.getApplicationContext();
    }

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = createComponent();
        component.inject(this);
    }

    private ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
