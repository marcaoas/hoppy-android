package com.marcaoas.hoppy.presentation.login.di;

import com.marcaoas.hoppy.presentation.di.PerActivity;
import com.marcaoas.hoppy.presentation.login.GoogleAuthHelper;
import com.marcaoas.hoppy.presentation.login.LoginActivity;
import com.marcaoas.hoppy.presentation.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marco on 19/04/17.
 */
@Module
public class LoginModule {

    private final LoginActivity context;

    public LoginModule(LoginActivity activity){
        this.context = activity;
    }

    @Provides
    @PerActivity
    public GoogleAuthHelper providesGoogleAuthenticatorHelper() {
        return new GoogleAuthHelper(context);
    }

    @Provides
    @PerActivity
    public LoginPresenter providesLoginPresenter() {
        return new LoginPresenter();
    }

}
