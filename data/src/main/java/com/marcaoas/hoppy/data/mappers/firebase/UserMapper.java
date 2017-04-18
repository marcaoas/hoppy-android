package com.marcaoas.hoppy.data.mappers.firebase;

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

}
