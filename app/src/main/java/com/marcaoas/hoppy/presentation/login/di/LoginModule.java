package com.marcaoas.hoppy.presentation.login.di;

import com.marcaoas.hoppy.domain.interactors.user.DoFacebookLoginInteractor;
import com.marcaoas.hoppy.domain.interactors.user.DoGoogleLoginInteractor;
import com.marcaoas.hoppy.domain.repositories.UserRepository;
import com.marcaoas.hoppy.presentation.di.PerActivity;
import com.marcaoas.hoppy.presentation.login.auth.FacebookAuthHelper;
import com.marcaoas.hoppy.presentation.login.auth.GoogleAuthHelper;
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
    public DoGoogleLoginInteractor providesGoogleLoginInteractor(UserRepository userRepository) {
        return new DoGoogleLoginInteractor(userRepository);
    }

    @Provides
    @PerActivity
    public DoFacebookLoginInteractor providesFacebookLoginInteractor(UserRepository userRepository) {
        return new DoFacebookLoginInteractor(userRepository);
    }

    @Provides
    @PerActivity
    public FacebookAuthHelper providesFacebookAuthHelper() {
        return new FacebookAuthHelper(context);
    }

    @Provides
    @PerActivity
    public GoogleAuthHelper providesGoogleAuthenticatorHelper() {
        return new GoogleAuthHelper(context);
    }

    @Provides
    @PerActivity
    public LoginPresenter providesLoginPresenter(DoGoogleLoginInteractor googleLoginInteractor, DoFacebookLoginInteractor doFacebookLoginInteractor) {
        return new LoginPresenter(googleLoginInteractor, doFacebookLoginInteractor);
    }

}
