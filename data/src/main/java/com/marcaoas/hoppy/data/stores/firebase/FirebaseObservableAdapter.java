package com.marcaoas.hoppy.data.stores.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.marcaoas.hoppy.data.models.ModelBase;
import com.marcaoas.hoppy.data.utils.Logger;

import io.reactivex.FlowableEmitter;

/**
 * Created by marco on 18/04/17.
 */

public class FirebaseObservableAdapter<T extends ModelBase> implements ValueEventListener {

    private final DatabaseReference objectDatabaseReference;
    private final Class<T> type;
    private FlowableEmitter<T> emitter;

    public FirebaseObservableAdapter(Class<T> type, @NonNull FlowableEmitter<T> emitter, @NonNull DatabaseReference userRerence){
        this.type = type;
        this.emitter = emitter;
        objectDatabaseReference = userRerence;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        T object = dataSnapshot.getValue(type);
        object.id = dataSnapshot.getKey();
        emitter.onNext(object);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Logger.e("Database error: " + databaseError.getMessage());
        emitter.onError(new Exception(databaseError.getMessage()));
    }

    public void registerForUpdates() {
        objectDatabaseReference.addValueEventListener(this);
    }
}
