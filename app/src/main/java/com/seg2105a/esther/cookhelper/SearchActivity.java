package com.seg2105a.esther.cookhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        // Get ListView object from xml layout
        ListView listView = (ListView) findViewById(R.id.listView);
        //Defining Array values to show in ListView
        String[] values = new String[] {
                "Spaghetti","Lasagna","Meatballs","Pasta Sauce","Raviolli","Cheese Sauce","Item 07","Item 08"
        };
        //Converting Array to ArrayList
        /*final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }*/
        //Create an ArrayAdapter and Set it on the ListView
        ArrayAdapter adapter = new RecipeAdapter(this, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                //Do something with the string that you just got!

            }
        });
    }

    public void advancedSearch(){
        // this should * inflate the advanced search page with all the components

    }

    public void recipeSelect(){
        // this is the action that represents the "Recipe" of the day being selected. The unique ID of the recipe is sent
        // to the recipe view page directly

    }

    public void search(){
        // refresh this result page with the information about what word to search for and in which scope

    }

    public void addRecipe(){
        // go to the edit recipe page with no information

    }
}
