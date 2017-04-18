package com.marcaoas.hoppy.domain.interactors.user;

import com.marcaoas.hoppy.domain.interactors.base.BaseInteractor;
import com.marcaoas.hoppy.domain.models.User;
import com.marcaoas.hoppy.domain.repositories.SettingsRepository;
import com.marcaoas.hoppy.domain.repositories.UserRepository;

import io.reactivex.Flowable;

/**
 * Created by marco on 17/04/17.
 */

public class GetCurrentUserInteractor extends BaseInteractor {

    private final UserRepository userRepository;
    private final SettingsRepository settingsRepository;

    public GetCurrentUserInteractor(UserRepository userRepository, SettingsRepository settingsRepository){
        this.userRepository = userRepository;
        this.settingsRepository = settingsRepository;
    }

    public Flowable<User> execute() {
        //TODO esta salvando um id de teste
        //TODO remover o saveCurrentUserId quando implementar login
        return settingsRepository.saveCurrentUserId("da39a3ee5e6b4b0d").andThen(
                settingsRepository.getCurrentUserId().flatMap(userRepository::getUser));
    }
}
