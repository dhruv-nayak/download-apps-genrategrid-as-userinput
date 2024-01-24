package com.example.vasundhara.adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vasundhara.R;
import com.example.vasundhara.models.gamesModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class gamesAdapter extends RecyclerView.Adapter<gamesAdapter.GameViewHolder>{
    private List<gamesModel.DataItem> gamesList = new ArrayList<>();
    private Context context;

    public gamesAdapter(List<gamesModel.DataItem> gamesList, Context context) {
        this.gamesList = gamesList;
        this.context = context;
    }

    @NonNull
    @Override
    public gamesAdapter.GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_layout, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull gamesAdapter.GameViewHolder holder, int position) {
        gamesModel.DataItem currentItem = gamesList.get(position);

        // Bind data to views in the ViewHolder
        holder.nametext.setText(currentItem.getName());
        holder.rangetext.setText("10000-50000");

        // Load thumbnail image using a library like Picasso/Glide into an ImageView
        Picasso.get().load(currentItem.getThumbImage()).into(holder.imageView);

        // Set click listener to open app link
        holder.Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appLink = currentItem.getAppLink();

                openPlayStore(appLink);
            }

        });

    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    public  class GameViewHolder extends RecyclerView.ViewHolder {

         TextView nametext;
         TextView rangetext;
        ImageView imageView;
         Button Download;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            nametext = itemView.findViewById(R.id.appname);
            rangetext = itemView.findViewById(R.id.range);
            imageView = itemView.findViewById(R.id.thumbnail);
            Download = itemView.findViewById(R.id.download);


        }


    }
    private void openPlayStore(String appLink) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(appLink));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "Play Store not found", Toast.LENGTH_SHORT).show();
        }
    }
}
