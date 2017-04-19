package com.marcaoas.hoppy.presentation.login.di;

import com.marcaoas.hoppy.presentation.di.ApplicationComponent;
import com.marcaoas.hoppy.presentation.di.PerActivity;
import com.marcaoas.hoppy.presentation.login.GoogleAuthHelper;
import com.marcaoas.hoppy.presentation.login.LoginActivity;
import com.marcaoas.hoppy.presentation.login.LoginPresenter;

import dagger.Component;

/**
 * Created by marco on 19/04/17.
 */
@PerActivity
@Component(modules = { LoginModule.class }, dependencies = { ApplicationComponent.class })
public interface LoginComponent {

    void inject(LoginActivity activity);

    LoginPresenter loginPresenter();
    GoogleAuthHelper googleSignInAuthenticator();
}
