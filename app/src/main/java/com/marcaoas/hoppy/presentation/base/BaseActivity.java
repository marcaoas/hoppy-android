package com.marcaoas.hoppy.presentation.base;

import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.marcaoas.hoppy.presentation.HoppyApplication;
import com.marcaoas.hoppy.presentation.di.ApplicationComponent;

/**
 * Created by marco on 15/04/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public HoppyApplication getHoppyApplication() {
        return HoppyApplication.get(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return getHoppyApplication().getComponent();
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }
}
