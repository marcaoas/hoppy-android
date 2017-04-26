package com.marcaoas.hoppy.domain.models;

/**
 * Created by marco on 17/04/17.
 */

public class User {

    private String id;
    private String name;
    private String email;
    private String profileImageUrl;
    private boolean anonymous;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public static User createAnonymousUser() {
        User user = new User();
        user.anonymous = true;
        return user;
    }
}
