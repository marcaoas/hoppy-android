package com.marcaoas.hoppy.domain.repositories;

import com.marcaoas.hoppy.domain.models.User;

import io.reactivex.Flowable;

/**
 * Created by marco on 17/04/17.
 */

public interface UserRepository {
    Flowable<User> getUser(String userId);
}