package com.example.minigooglenews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApi {

    @GET("top-headlines?country=us&category=business&apiKey=56aa6cc3f7434d3cabb5c16932360d16")
    Call<ArticlesData> getNews();
}
