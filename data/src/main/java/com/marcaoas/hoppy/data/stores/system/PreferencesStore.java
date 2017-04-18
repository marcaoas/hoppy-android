package com.marcaoas.hoppy.data.stores.system;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Created by marco on 18/04/17.
 */

public class PreferencesStore {

    private final SharedPreferences sharedPreferences;

    public PreferencesStore(SharedPreferences preferences) {
        this.sharedPreferences = preferences;
    }

    public Flowable<String> getString(@NonNull String key, String defaultValue) {
        return Flowable.create( emitter -> {
            emitter.onNext(sharedPreferences.getString(key, defaultValue));
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }

    public Flowable<String> getString(@NonNull String key) {
        return getString(key, null);
    }

    @SuppressLint("ApplySharedPref")
    public Completable putString(@NonNull String key, @Nullable String value) {
        return Completable.create( emitter -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.commit();
            emitter.onComplete();
        });
    }

    public Flowable<Integer> getInt(@NonNull String key, int defaultValue) {
        return Flowable.create( emitter -> {
            emitter.onNext(sharedPreferences.getInt(key, defaultValue));
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }

    public Flowable<Integer> getInt(@NonNull String key) {
        return getInt(key, 0);
    }

    @SuppressLint("ApplySharedPref")
    public Completable putInt(@NonNull String key, int value) {
        return Completable.create( emitter -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(key, value);
            editor.commit();
            emitter.onComplete();
        });
    }

    public Flowable<Boolean> getBoolean(@NonNull String key, boolean defaultValue) {
        return Flowable.create( emitter -> {
            emitter.onNext(sharedPreferences.getBoolean(key, defaultValue));
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }

    public Flowable<Boolean> getBoolean(@NonNull String key) {
        return getBoolean(key, false);
    }

    @SuppressLint("ApplySharedPref")
    public Completable putBoolean(@NonNull String key, boolean value) {
        return Completable.create( emitter -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(key, value);
            editor.commit();
            emitter.onComplete();
        });
    }

    public Flowable<Float> getFloat(@NonNull String key, float defaultValue) {
        return Flowable.create( emitter -> {
            emitter.onNext(sharedPreferences.getFloat(key, defaultValue));
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }

    public Flowable<Float> getFloat(@NonNull String key) {
        return getFloat(key, 0);
    }

    @SuppressLint("ApplySharedPref")
    public Completable putFloat(@NonNull String key, float value) {
        return Completable.create( emitter -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putFloat(key, value);
            editor.commit();
            emitter.onComplete();
        });
    }


    public Flowable<Long> getLong(@NonNull String key, long defaultValue) {
        return Flowable.create( emitter -> {
            emitter.onNext(sharedPreferences.getLong(key, defaultValue));
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);
    }

    public Flowable<Long> getLong(@NonNull String key) {
        return getLong(key, 0);
    }

    @SuppressLint("ApplySharedPref")
    public Completable putLong(@NonNull String key, long value) {
        return Completable.create( emitter -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong(key, value);
            editor.commit();
            emitter.onComplete();
        });
    }
}
