package com.marcaoas.hoppy.domain.interactors.user;

import com.marcaoas.hoppy.domain.interactors.base.BaseInteractor;
import com.marcaoas.hoppy.domain.models.User;
import com.marcaoas.hoppy.domain.repositories.UserRepository;

import io.reactivex.Single;

/**
 * Created by marco on 20/04/17.
 */

public class DoGoogleLoginInteractor extends BaseInteractor {

    private final UserRepository userRepository;

    public DoGoogleLoginInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Single<User> execute(String googleIdToken) {
        return userRepository.getWithGoogle(googleIdToken);
    }

}
