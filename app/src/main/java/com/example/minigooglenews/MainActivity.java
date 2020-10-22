package com.example.minigooglenews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArticlesData articlesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        IApi apiService = ApiClient.getClient().create(IApi.class);
        Call<ArticlesData> call = apiService.getNews();

        call.enqueue(new Callback<ArticlesData>() {
            @Override
            public void onResponse(Call<ArticlesData> call, Response<ArticlesData> response) {

                assert response.body() != null;
                ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.news_list_item, response.body());
                articlesData=new ArticlesData(response.body().getStatus(),response.body().getTotalResults(),response.body().getArticles());

                recyclerView.setAdapter(itemArrayAdapter);
            }

            @Override
            public void onFailure(Call<ArticlesData> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString(),t);
            }
        });

    }
}