package com.marcaoas.hoppy.presentation.menu.di;

import com.marcaoas.hoppy.data.stores.firebase.UserDataStore;
import com.marcaoas.hoppy.presentation.di.ApplicationComponent;
import com.marcaoas.hoppy.presentation.di.PerActivity;
import com.marcaoas.hoppy.presentation.di.data.settings.SettingsDataModule;
import com.marcaoas.hoppy.presentation.di.data.user.UserDataModule;
import com.marcaoas.hoppy.presentation.menu.MenuFragment;
import com.marcaoas.hoppy.presentation.menu.MenuPresenter;

import dagger.Component;

/**
 * Created by marco on 15/04/17.
 */
@Component(modules = { MenuModule.class }, dependencies = { ApplicationComponent.class })
@PerActivity
public interface MenuComponent {
    MenuPresenter menuPresenter();
    void inject(MenuFragment menuFragment);
}
