package com.marcaoas.hoppy.data.stores.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by marco on 18/04/17.
 */

public abstract class FirebaseDataStore {

    private final String dataKey;

    public FirebaseDataStore(@NonNull String dataKey) {
        this.dataKey = dataKey;
    }

    protected DatabaseReference getDataReference() {
        return FirebaseDatabase.getInstance().getReference();
    }

    protected DatabaseReference getData() {
        return getDataReference().child(dataKey);
    }

}
