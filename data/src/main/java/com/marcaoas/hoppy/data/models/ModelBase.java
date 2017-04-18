package com.marcaoas.hoppy.data.models;

import java.util.Map;

/**
 * Created by marco on 18/04/17.
 */

public abstract class ModelBase {
    public String id;

    public abstract Map<String, Object> toMap();
}
