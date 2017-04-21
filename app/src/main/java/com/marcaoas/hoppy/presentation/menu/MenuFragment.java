package com.marcaoas.hoppy.presentation.menu;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.databinding.FragmentMenuBinding;
import com.marcaoas.hoppy.databinding.MenuHeaderBinding;
import com.marcaoas.hoppy.presentation.base.BaseFragment;
import com.marcaoas.hoppy.presentation.main.MainActivity;
import com.marcaoas.hoppy.presentation.menu.di.DaggerMenuComponent;
import com.marcaoas.hoppy.presentation.menu.models.UserMenu;

import javax.inject.Inject;

/**
 * Created by marco on 15/04/17.
 */

public class MenuFragment extends BaseFragment<MainActivity> implements MenuContract.View {

    @Inject
    MenuPresenter presenter;

    private FragmentMenuBinding binding;
    private MenuHeaderBinding menuHeaderBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initializeInjector();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false);
        menuHeaderBinding = DataBindingUtil.inflate(inflater, R.layout.menu_header, container, false);
        binding.navigationView.addHeaderView(menuHeaderBinding.getRoot());
        presenter.initView(this);
        return binding.getRoot();
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
        menuHeaderBinding.setUser(user);
    }

}
