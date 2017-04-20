package com.marcaoas.hoppy.data.repositories;

import com.marcaoas.hoppy.data.mappers.firebase.UserMapper;
import com.marcaoas.hoppy.data.stores.firebase.UserDataStore;
import com.marcaoas.hoppy.domain.models.User;
import com.marcaoas.hoppy.domain.repositories.UserRepository;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by marco on 17/04/17.
 */

public class UserRepositoryImpl implements UserRepository {

    private final UserDataStore diskStore;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserDataStore diskStore, UserMapper userMapper) {
        this.diskStore = diskStore;
        this.userMapper = userMapper;
    }

    @Override
    public Flowable<User> getUser(String userId) {
        return diskStore.getUser(userId).map(userMapper::map);
    }

    @Override
    public Single<User> getWithGoogle(String googleIdToken) {
        return diskStore.getWithGoogle(googleIdToken).map(userMapper::map);
    }

}
