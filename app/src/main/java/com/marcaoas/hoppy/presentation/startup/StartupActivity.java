package com.marcaoas.hoppy.presentation.startup;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.databinding.ActivityStartupBinding;
import com.marcaoas.hoppy.presentation.base.BaseActivity;
import com.marcaoas.hoppy.presentation.startup.di.DaggerStartupComponent;
import com.marcaoas.hoppy.presentation.utils.Logger;

import javax.inject.Inject;

/**
 * Created by marco on 21/04/17.
 */

public class StartupActivity extends BaseActivity implements StartupContract.View {

    private ActivityStartupBinding binding;

    @Inject
    StartupPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_startup);
        initializeInjector();
        presenter.initView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.load();
    }

    private void initializeInjector() {
        DaggerStartupComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build()
                .inject(this);
    }

    @Override
    public void goToMain() {
        Logger.d("go main");
    }

    @Override
    public void goToLogin() {
        Logger.d("go main");
    }
}
