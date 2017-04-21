package com.marcaoas.hoppy.presentation.startup;

import com.marcaoas.hoppy.domain.interactors.user.GetCurrentUserInteractor;
import com.marcaoas.hoppy.presentation.base.BasePresenter;
import com.marcaoas.hoppy.presentation.utils.Logger;

/**
 * Created by marco on 21/04/17.
 */

public class StartupPresenter extends BasePresenter<StartupContract.View> {

    private final GetCurrentUserInteractor getCurrentUserInteractor;

    public StartupPresenter(GetCurrentUserInteractor getCurrentUserInteractor) {
        this.getCurrentUserInteractor = getCurrentUserInteractor;
    }

    public void load() {
        getCurrentUserInteractor.execute().subscribe(
                user -> {
                    Logger.d("User: " + user.getId());
                    Logger.d("User Name: " + user.getName());
                    Logger.d("User Email: " + user.getEmail());
                    Logger.d("User Photo: " + user.getProfileImageUrl());
                    view.goToMain();
                },
                error -> view.goToLogin());
    }
}
