package com.marcaoas.hoppy.domain.repositories;

import com.marcaoas.hoppy.domain.models.User;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by marco on 17/04/17.
 */

public interface UserRepository {
    Flowable<User> getUser(String userId);
    Single<User> getCurrentUser();
    Single<User> getWithGoogle(String googleIdToken);
}