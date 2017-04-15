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
import com.marcaoas.hoppy.presentation.menu.models.UserMenu;

/**
 * Created by marco on 15/04/17.
 */

public class MenuFragment extends BaseFragment implements MenuContract.View {

//    @Inject
//    MenuPresenter presenter;
    private FragmentMenuBinding binding;
    private MenuHeaderBinding menuHeaderBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initializeInjector();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false);
        menuHeaderBinding = DataBindingUtil.inflate(inflater, R.layout.menu_header, container, false);
        binding.navigationView.addHeaderView(menuHeaderBinding.getRoot());
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void initializeInjector() {
    }

    @Override
    public void setUser(UserMenu user) {
        if(user == null) return ;
        menuHeaderBinding.menuUserNameTextView.setText(user.name);
        menuHeaderBinding.menuUserEmailTextView.setText(user.email);
        //TODO set image profile Url
    }

}
