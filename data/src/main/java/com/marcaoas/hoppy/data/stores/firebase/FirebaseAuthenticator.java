package com.marcaoas.hoppy.data.stores.firebase;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.marcaoas.hoppy.data.utils.Logger;
import com.marcaoas.hoppy.domain.models.User;

import java.util.concurrent.Executor;

import io.reactivex.SingleEmitter;

/**
 * Created by marco on 20/04/17.
 */

class FirebaseAuthenticator implements OnCompleteListener<AuthResult> {

    private final FirebaseAuth firebaseInstance;
    private final SingleEmitter<FirebaseUser> emitter;
    private final String token;

    public FirebaseAuthenticator(SingleEmitter<FirebaseUser> emitter) {
        this.emitter = emitter;
        this.token = null;
        firebaseInstance = FirebaseAuth.getInstance();
    }

    public FirebaseAuthenticator(SingleEmitter<FirebaseUser> emitter, String credential) {
        this.emitter = emitter;
        this.token = credential;
        firebaseInstance = FirebaseAuth.getInstance();
    }

    public FirebaseAuth getFirebaseInstance() {
        return firebaseInstance;
    }

    public void getCurrentUser() {
        FirebaseUser user = firebaseInstance.getCurrentUser();
        if(user!=null) {
            emitter.onSuccess(user);
        } else {
            emitter.onError(new Exception("User not authenticated"));
        }

    }


    public void signInWithFacebook() {
        AuthCredential credential = FacebookAuthProvider.getCredential(token);
        linkWith(credential);
    }

    public void signInWithGoogle() {
        AuthCredential credential = GoogleAuthProvider.getCredential(token, null);
        linkWith(credential);
    }

    private void linkWithCredentials(FirebaseUser user, AuthCredential credential) {
        user.linkWithCredential(credential).addOnCompleteListener(this);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            Logger.d("signInWithCredential:success");
            FirebaseUser user = getFirebaseInstance().getCurrentUser();
            if(user.isAnonymous()){
                emitter.onSuccess(user);
            } else {
                updateUserProfileData(user);
            }
        } else {
            Logger.d("signInWithCredential:error");
            emitter.onError(new Exception("Firebase Sign in failed"));
        }
    }


    private void updateUserProfileData(FirebaseUser user) {
        int providerDataSize = user.getProviderData().size();
        UserInfo providerData = user.getProviderData().get(providerDataSize > 0 ? providerDataSize - 1 : 0);
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(providerData.getDisplayName())
                .setPhotoUri(providerData.getPhotoUrl())
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        emitter.onSuccess(user);
                    }
                });
    }

    public void signInAnonymously() {
        getFirebaseInstance().signInAnonymously()
                .addOnCompleteListener(this);
    }

    public void linkWith(AuthCredential credential) {
        FirebaseUser currentUser = getFirebaseInstance().getCurrentUser();
        if(currentUser != null) {
            linkWithCredentials(currentUser, credential);
        } else {
            getFirebaseInstance().signInAnonymously().addOnCompleteListener(
                    user ->
                            linkWithCredentials(getFirebaseInstance().getCurrentUser(), credential)
            );
        }
    }
}
