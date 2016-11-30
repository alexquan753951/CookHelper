package com.seg2105a.esther.cookhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Esther on 2016-11-29.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void advancedSearch(){
        // this should inflate the advanced search page with all the components

    }

    public void recipeSelect(){
        // this is the action that represents the "Recipe" of the day being selected. The unique ID of the recipe is sent
        // to the recipe view page directly

    }

    public void search(){
        // go to the search result page with the information about what word to search for and in which scope

    }

    public void help(){
        // display help dialogue box with the information about how to parse the advavnced Category items and use the app...
        // can be a seperate page if interested
    }
}
