package com.marcaoas.hoppy.presentation.menu;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.databinding.FragmentMenuBinding;
import com.marcaoas.hoppy.databinding.MenuHeaderBinding;
import com.marcaoas.hoppy.presentation.Navigator;
import com.marcaoas.hoppy.presentation.base.BaseFragment;
import com.marcaoas.hoppy.presentation.main.MainActivity;
import com.marcaoas.hoppy.presentation.menu.di.DaggerMenuComponent;
import com.marcaoas.hoppy.presentation.menu.models.Menu;
import com.marcaoas.hoppy.presentation.menu.models.UserMenu;

import javax.inject.Inject;

/**
 * Created by marco on 15/04/17.
 */

public class MenuFragment extends BaseFragment<MainActivity> implements MenuContract.View, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    MenuPresenter presenter;
    @Inject
    Navigator navigator;

    private FragmentMenuBinding binding;
    private MenuHeaderBinding menuHeaderBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initializeInjector();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false);
        presenter.initView(this);
        setupView(inflater, container);
        return binding.getRoot();
    }

    private void setupView(LayoutInflater inflater, @Nullable ViewGroup container) {
        menuHeaderBinding = DataBindingUtil.inflate(inflater, R.layout.menu_header, container, false);
        binding.navigationView.addHeaderView(menuHeaderBinding.getRoot());
        menuHeaderBinding.menuSignInAction.setOnClickListener(view -> getHostingActivity().goToLogin());
        binding.navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.loadUser();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dimiss();
    }

    public void initializeInjector() {
        DaggerMenuComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build()
                .inject(this);
    }

    @Override
    public void setUser(UserMenu user) {
        if(user == null) return ;
        if(user.isAnonymous) {
            user.name = getString(R.string.anonymous_user_name);
        }
        menuHeaderBinding.setUser(user);
    }

    @Override
    public void goToLogin() {
        getHostingActivity().goToLogin();
    }

    @Override
    public void goToBrewSteps() {
        navigator.toBrewSteps(getHostingActivity());
    }

    @Override
    public void goToMyRecipes() {
        navigator.toMyRecipes(getHostingActivity());
    }

    @Override
    public void goToInventory() {
        navigator.toInventory(getHostingActivity());
    }

    @Override
    public void goToBrewingTools() {
        navigator.toBrewingTools(getHostingActivity());
    }

    @Override
    public void goToShoppingList() {
        navigator.toShoppingList(getHostingActivity());
    }

    @Override
    public void goToSettings() {
        navigator.toSettings(getHostingActivity());
    }

    @Override
    public void logout() {
        getHostingActivity().logout();
    }

    @Override
    public void closeMenu() {
        getHostingActivity().closeMenu();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        presenter.onItemSelected(Menu.getItemFromId(item.getItemId()));
        return true;
    }
}
