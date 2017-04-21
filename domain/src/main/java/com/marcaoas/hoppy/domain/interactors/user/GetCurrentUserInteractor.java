package com.marcaoas.hoppy.domain.interactors.user;

import com.marcaoas.hoppy.domain.interactors.base.BaseInteractor;
import com.marcaoas.hoppy.domain.models.User;
import com.marcaoas.hoppy.domain.repositories.UserRepository;

import io.reactivex.Single;

/**
 * Created by marco on 17/04/17.
 */

public class GetCurrentUserInteractor extends BaseInteractor {

    private final UserRepository userRepository;

    public GetCurrentUserInteractor(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Single<User> execute() {
        return userRepository.getCurrentUser();
    }
}
