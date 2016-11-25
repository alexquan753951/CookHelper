package com.seg2105a.esther.cookhelper;

/**
 * Created by Esther on 2016-11-25.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    public RecipeAdapter(Context context, String[] values) {
        super(context, R.layout.recipe_list_layout, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.recipe_list_layout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.itemName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
        // Change the icon for Windows and iPhone
        String s = values[position];
        if (s == null || s.isEmpty() || s.equals("empty")) {
            imageView.setImageResource(R.drawable.ic_logo_00);
        } else {
            imageView.setImageResource(R.drawable.ic_logo_01);
        }
        return rowView;
    }
}
