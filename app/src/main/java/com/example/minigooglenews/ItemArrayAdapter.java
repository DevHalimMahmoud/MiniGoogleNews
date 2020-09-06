package com.example.minigooglenews;

import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {
    private int listItemLayout;
    private ArrayList<ArticlesData> articlesData;
    public ItemArrayAdapter(int layoutId, ArrayList<ArticlesData> articlesData) {
        listItemLayout = layoutId;
        this.articlesData = articlesData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int listPosition) {
         ImageView imageView =holder.imageView;
         TextView title= holder.title;
        TextView description=holder.description;
        TextView source_name=holder.source_name;
        ArrayList<Article> articles= articlesData.get(listPosition).getArticles();
        ArrayList<Source> sources=articles.get(listPosition).getSources();
        title.setText(articles.get(listPosition).getTitle());
        description.setText(articles.get(listPosition).getDescription());
        source_name.setText(sources.get(listPosition).getName());
    }

    @Override
    public int getItemCount() {
        return articlesData == null ? 0 : articlesData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements com.example.minigooglenews.ViewHolder, View.OnClickListener {
        public ImageView imageView;
        public TextView title,description,source_name;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);
            title=(TextView) itemView.findViewById(R.id.title);
            description=(TextView) itemView.findViewById(R.id.description);
            source_name=(TextView) itemView.findViewById(R.id.source_name);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + title.getText());
        }
    }
}
