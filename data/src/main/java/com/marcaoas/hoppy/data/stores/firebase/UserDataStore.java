package com.marcaoas.hoppy.data.stores.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseUser;
import com.marcaoas.hoppy.data.mappers.firebase.UserMapper;
import com.marcaoas.hoppy.data.models.ApiUser;
import com.marcaoas.hoppy.domain.models.User;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

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

    public Single<FirebaseUser> getWithGoogle(String credential) {
        return Single.create(emitter -> {
            FirebaseAuthenticator firebaseAuthenticator = new FirebaseAuthenticator(emitter, credential);
            firebaseAuthenticator.signInWithGoogle();
        });
    }

    public Single<FirebaseUser> getCurrentUser() {
        return Single.create(emitter -> {
            FirebaseAuthenticator firebaseAuthenticator = new FirebaseAuthenticator(emitter);
            firebaseAuthenticator.getCurrentUser();
        });
    }
}
