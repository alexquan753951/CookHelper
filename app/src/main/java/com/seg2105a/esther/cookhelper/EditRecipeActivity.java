package com.seg2105a.esther.cookhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Esther on 2016-11-29.
 */

public class EditRecipeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_form);

        // if information is being edited, first populate fields

        // else treat like add activity & create a new Recipe Object to place in the Database
    }

    public void save() {
        // save changes to database
    }

    public void cancel() {
        // cancel changes and return to home screen....
    }

    public void browseImages() {
        // looks in file system for any images the useer wants to use, saves in database using the Recipe ID....
    }
}