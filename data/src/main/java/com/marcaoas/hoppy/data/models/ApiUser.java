package com.marcaoas.hoppy.data.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marco on 18/04/17.
 */
@IgnoreExtraProperties
public class ApiUser extends ModelBase {

    public String name;
    public String email;
    public String profilePictureUrl;

    @Exclude
    @Override
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        result.put("email", email);
        result.put("profilePictureUrl", profilePictureUrl);
        return result;
    }
}
