package com.marcaoas.hoppy.presentation.recipes.my;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.marcaoas.hoppy.R;
import com.marcaoas.hoppy.databinding.RecipeListItemBinding;
import com.marcaoas.hoppy.domain.interactors.recipe.GetMyRecipesInteractor;
import com.marcaoas.hoppy.presentation.recipes.model.RecipeListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 26/04/17.
 */

public class MyRecipesAdapter extends RecyclerView.Adapter<MyRecipesAdapter.MyRecipesViewHolder> {

    private final List<RecipeListItem> recipesList;

    public MyRecipesAdapter() {
        this.recipesList = new ArrayList<>();
    }

    @Override
    public MyRecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecipeListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.recipe_list_item, parent, false);
        return new MyRecipesViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }

    @Override
    public void onBindViewHolder(MyRecipesViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @NonNull
    public RecipeListItem getItem(int position) {
        return recipesList.get(position);
    }

    public void addRecipe(@NonNull RecipeListItem recipe) {
        recipesList.add(recipe);
        notifyDataSetChanged();
    }

    public void addRecipes(@NonNull List<RecipeListItem> recipesList) {
        this.recipesList.addAll(recipesList);
        notifyDataSetChanged();
    }

    class MyRecipesViewHolder extends RecyclerView.ViewHolder {

        final RecipeListItemBinding binding;

        public MyRecipesViewHolder(@NonNull RecipeListItemBinding viewBinding) {
            super(viewBinding.getRoot());
            this.binding = viewBinding;
        }

        public void bind(@NonNull RecipeListItem item) {
            binding.setRecipe(item);
        }
    }


    @BindingAdapter({"app:recipeImageUrl"})
    public static void loadRecipeImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .centerCrop()
                .error(R.drawable.ic_profile_placeholder) //TODO change recipe placeholder
                .placeholder(R.drawable.ic_profile_placeholder)//TODO change recipe placeholder
                .into(view);
    }
}
