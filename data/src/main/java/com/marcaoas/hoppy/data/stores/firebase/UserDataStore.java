package com.marcaoas.hoppy.data.stores.firebase;

import android.support.annotation.NonNull;

import com.marcaoas.hoppy.data.models.ApiUser;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

/**
 * Created by marco on 18/04/17.
 */

public class UserDataStore extends FirebaseDataStore {
    private static final String USER_DATA_KEY = "users";

    public UserDataStore() {
        super(USER_DATA_KEY);
    }

    public Flowable<ApiUser> getUser(@NonNull String userKeyHash) {
        return Flowable.create( e -> {
            FirebaseObservableAdapter firebaseObservable = new FirebaseObservableAdapter<>(
                    ApiUser.class, e, getData().child(userKeyHash));
            firebaseObservable.registerForUpdates();
        },BackpressureStrategy.BUFFER);
    }
}
