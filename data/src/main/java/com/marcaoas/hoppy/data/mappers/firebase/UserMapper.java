package com.marcaoas.hoppy.data.mappers.firebase;

import android.net.Uri;

import com.google.firebase.auth.FirebaseUser;
import com.marcaoas.hoppy.data.models.ApiUser;
import com.marcaoas.hoppy.domain.models.User;

/**
 * Created by marco on 18/04/17.
 */

public class UserMapper {

    public User map(ApiUser apiUser) {
        if(apiUser == null) return null;
        User user = new User();
        user.setId(apiUser.id);
        user.setName(apiUser.name);
        user.setEmail(apiUser.email);
        user.setProfileImageUrl(apiUser.profilePictureUrl);
        return user;
    }

    public User map(FirebaseUser firebaseUser) {
        User user = new User();
        user.setId(firebaseUser.getUid());
        user.setName(firebaseUser.getDisplayName());
        user.setEmail(firebaseUser.getEmail());
        Uri profileUri = firebaseUser.getPhotoUrl();
        if(profileUri!=null){
            user.setProfileImageUrl(profileUri.toString());
        }
        return user;
    }

}
