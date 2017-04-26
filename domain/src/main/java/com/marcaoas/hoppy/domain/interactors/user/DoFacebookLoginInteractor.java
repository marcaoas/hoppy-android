package com.marcaoas.hoppy.domain.interactors.user;

import com.marcaoas.hoppy.domain.models.User;
import com.marcaoas.hoppy.domain.repositories.UserRepository;

import io.reactivex.Single;

/**
 * Created by marco on 24/04/17.
 */

public class DoFacebookLoginInteractor {

    private final UserRepository userRepository;

    public DoFacebookLoginInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Single<User> execute(String token) {
        return userRepository.getWithFacebook(token);
    }

}
