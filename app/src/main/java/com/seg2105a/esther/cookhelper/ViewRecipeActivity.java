package com.seg2105a.esther.cookhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Esther on 2016-11-29.
 */

public class ViewRecipeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        //loads the activity and populates the text view with information from the Recipe object
    }

    public void playRecipeStep(){
        //goes to the RecipeStep
    }

    public void editRecipe(){
        // edits the valuesin the recipe by first going to the recipe forma and changing the values
    }

    public void deleteRecipe(){
        // deletes the recipe from the Business Logic as well as the database
    }
}