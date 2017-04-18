package com.marcaoas.hoppy.domain.repositories;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * Created by marco on 18/04/17.
 */

public interface SettingsRepository {
    Flowable<String> getCurrentUserId();
    Completable saveCurrentUserId(String currentUserId);
}
