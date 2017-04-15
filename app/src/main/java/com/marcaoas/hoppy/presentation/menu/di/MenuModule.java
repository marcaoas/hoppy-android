package com.marcaoas.hoppy.presentation.menu.di;

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
    public MenuPresenter providesMenuPresenter() {
        return new MenuPresenter();
    }

}
