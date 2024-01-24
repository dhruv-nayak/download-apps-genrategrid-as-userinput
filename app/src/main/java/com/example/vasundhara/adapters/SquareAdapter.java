package com.example.vasundhara.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.example.vasundhara.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareAdapter extends BaseAdapter {

    private Context context;
    private int gridSize;
    private List<Boolean> isClickedList;
    public SquareAdapter(Context context, int gridSize) {
        this.context = context;
        this.gridSize = gridSize;
        this.isClickedList = new ArrayList<>(Collections.nCopies(gridSize * gridSize, false));
    }

    @Override
    public int getCount() {
        return gridSize * gridSize;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (inflater != null) {
                view = inflater.inflate(R.layout.box, parent, false);
            }
        }

        // Set up the square shape here (customize as per your needs)
        ImageView square = view.findViewById(R.id.square);
        // Customize square appearance (color, shape, etc.)
        square.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        Animation blinkAnimation = AnimationUtils.loadAnimation(context, R.anim.blink);

// Apply the animation to the button


        // Check if the square is clicked or not
        if (isClickedList.get(position)) {
            square.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
        } else {
            square.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }

        // Set click listener for the square button
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClickedList.set(position, !isClickedList.get(position)); // Toggle click state
                notifyDataSetChanged(); // Refresh the GridView
                square.startAnimation(blinkAnimation);
            }
        });

        return view;
    }
}