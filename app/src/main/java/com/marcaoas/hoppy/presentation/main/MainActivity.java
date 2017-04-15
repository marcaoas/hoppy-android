package com.marcaoas.hoppy.presentation.main;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.databinding.ActivityMainBinding;
import com.marcaoas.hoppy.presentation.base.BaseActivity;
import com.marcaoas.hoppy.presentation.menu.MenuFragment;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        configureToolbar();
        configureDrawerMenu();

        //Setting Menu Fragment
        addFragment(R.id.menu_frame, new MenuFragment());
    }

    private void configureDrawerMenu() {
        drawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout,
                binding.toolbar, R.string.app_name, R.string.app_name) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        binding.drawerLayout.addDrawerListener(drawerToggle);
    }

    private void configureToolbar() {
        setSupportActionBar(binding.toolbar);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
