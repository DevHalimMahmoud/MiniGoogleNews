package com.example.minigooglenews;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {
    private int listItemLayout;
    private ArticlesData articlesData;
    private View view;


    public ItemArrayAdapter(int layoutId, ArticlesData articlesData) {
        listItemLayout = layoutId;
        this.articlesData = articlesData;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( final ViewHolder holder, final int listPosition) {

        TextView title = holder.title;
        TextView description = holder.description;
        TextView source_name = holder.source_name;

        ArrayList<Article> articles = articlesData.getArticles();
        Glide.with(view.getContext()).load(articles.get(listPosition).getUrlToImage()).apply(RequestOptions.centerCropTransform()).into(holder.imageView);
        title.setText(articles.get(listPosition).getTitle());
        description.setText(articles.get(listPosition).getDescription());
        Source sources = articles.get(listPosition).getSources();
        if(sources.getId()!=null && sources.getName() != null){
            source_name.setText(sources.getName());}
    }

    @Override
    public int getItemCount() {

        if (articlesData.getArticles() != null) {
            return articlesData.getArticles().size();
        }
        return 0;

    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView title, description, source_name;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);
            imageView=itemView.findViewById(R.id.imageView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            source_name = (TextView) itemView.findViewById(R.id.source_name);
        }

        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + title.getText());
        }
    }
}
