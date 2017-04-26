package com.marcaoas.hoppy.presentation.di.data.recipe;

import com.marcaoas.hoppy.domain.models.Recipe;
import com.marcaoas.hoppy.domain.repositories.RecipeRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by marco on 26/04/17.
 */

public class MockRecipeRepository implements RecipeRepository {
    @Override
    public Flowable<List<Recipe>> getMyRecipesList() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        Recipe recipe1 = new Recipe();
        recipe1.setTitle("Lost in Echo Outmeal");
        recipe1.setImageUrl("http://www.beersmith.com/blog/wp-content/uploads/2008/03/istock_stout_line.jpg");
        recipe1.setBeerType("Outmeal stout");
        recipes.add(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setTitle("Nordika Ecbert");
        recipe2.setImageUrl("http://www.slate.com/content/dam/slate/articles/technology/future_tense/2012/02/120221_FT_homebrew.jpg.CROP.original-original.jpg");
        recipe2.setBeerType("Extra Special Bitter (ESB)");
        recipes.add(recipe2);

        Recipe recipe3 = new Recipe();
        recipe3.setTitle("Nordika IPA bem desgraçada");
        recipe3.setImageUrl("https://static1.squarespace.com/static/51ef2bf2e4b02bcf8471333b/t/580501e5e4fcb5b09bbc81f4/1476723186797/Northern-Brewer-InBev");
        recipe3.setBeerType("India Pale Ale (IPA)");
        recipes.add(recipe3);

        Recipe recipe4 = new Recipe();
        recipe4.setTitle("Nodika Helga");
        recipe4.setImageUrl("http://www.brewniversebeerstore.com/wp-content/uploads/2013/05/Grains.jpg");
        recipe4.setBeerType("Blonde Ale");
        recipes.add(recipe4);
        return Flowable.fromArray(recipes);
    }
}
