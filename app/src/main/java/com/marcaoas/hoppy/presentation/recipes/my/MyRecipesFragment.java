package com.marcaoas.hoppy.presentation.recipes.my;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.databinding.FragmentMyRecipesBinding;
import com.marcaoas.hoppy.presentation.base.BaseFragment;
import com.marcaoas.hoppy.presentation.main.MainActivity;
import com.marcaoas.hoppy.presentation.recipes.model.RecipeListItem;
import com.marcaoas.hoppy.presentation.recipes.my.di.DaggerMyRecipesComponent;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by marco on 26/04/17.
 */

public class MyRecipesFragment extends BaseFragment<MainActivity> implements MyRecipesContract.View {

    @Inject
    MyRecipesPresenter presenter;
    @Inject
    MyRecipesAdapter adapter;

    private FragmentMyRecipesBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initializeInjector();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_recipes, container, false);
        presenter.initView(this);
        setupView();
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.load();
    }

    private void setupView() {
        getHostingActivity().setTitle(R.string.my_recipes_fragment_title);
        binding.myRecipesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.myRecipesRecyclerView.setAdapter(adapter);
    }

    private void initializeInjector() {
        DaggerMyRecipesComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build()
                .inject(this);
    }

    @Override
    public void showLoading() {
        //TODO show loading
    }

    @Override
    public void showError() {
        //TODO show error
    }

    @Override
    public void showEmptyList() {
        //TODO show empty list
    }

    @Override
    public void addRecipes(List<RecipeListItem> recipes) {
        adapter.addRecipes(recipes);
    }
}
