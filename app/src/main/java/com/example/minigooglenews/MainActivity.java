package com.example.minigooglenews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Source> sources = new ArrayList<>();

        sources.add(new Source(1, "Binance"));
        sources.add(new Source(1, "Binance"));
        sources.add(new Source(1, "Binance"));
        sources.add(new Source(1, "Binance"));

        ArrayList<Article> articles = new ArrayList<>();

        articles.add(new Article(sources, "Cointelegraph By Joseph Young", "3 reasons why Bitcoin suddenly dipped under $10K today — and recovered", "The price of Bitcoin briefly dropped below $10,000, causing the entire cryptocurrency market to slump in a short period.", "https://cointelegraph.com/news/3-reasons-why-bitcoin-suddenly-dipped-under-10k-today-and-recovered", "https://s3.cointelegraph.com/storage/uploads/view/4275d592b2b6ee0bceed726b684d83c5.jpg", "2020-09-05T15:21:00Z", "The price of Bitcoin (BTC) dropped to sub-$10,000 across major exchanges again on Sep. 5, marking two consecutive days of testing the crucial level. Other major cryptocurrencies, including Ethereums … [+3510 chars]"));
        articles.add(new Article(sources, "Cointelegraph By Joseph Young", "3 reasons why Bitcoin suddenly dipped under $10K today — and recovered", "The price of Bitcoin briefly dropped below $10,000, causing the entire cryptocurrency market to slump in a short period.", "https://cointelegraph.com/news/3-reasons-why-bitcoin-suddenly-dipped-under-10k-today-and-recovered", "https://s3.cointelegraph.com/storage/uploads/view/4275d592b2b6ee0bceed726b684d83c5.jpg", "2020-09-05T15:21:00Z", "The price of Bitcoin (BTC) dropped to sub-$10,000 across major exchanges again on Sep. 5, marking two consecutive days of testing the crucial level. Other major cryptocurrencies, including Ethereums … [+3510 chars]"));
        articles.add(new Article(sources, "Cointelegraph By Joseph Young", "3 reasons why Bitcoin suddenly dipped under $10K today — and recovered", "The price of Bitcoin briefly dropped below $10,000, causing the entire cryptocurrency market to slump in a short period.", "https://cointelegraph.com/news/3-reasons-why-bitcoin-suddenly-dipped-under-10k-today-and-recovered", "https://s3.cointelegraph.com/storage/uploads/view/4275d592b2b6ee0bceed726b684d83c5.jpg", "2020-09-05T15:21:00Z", "The price of Bitcoin (BTC) dropped to sub-$10,000 across major exchanges again on Sep. 5, marking two consecutive days of testing the crucial level. Other major cryptocurrencies, including Ethereums … [+3510 chars]"));
        articles.add(new Article(sources, "Cointelegraph By Joseph Young", "3 reasons why Bitcoin suddenly dipped under $10K today — and recovered", "The price of Bitcoin briefly dropped below $10,000, causing the entire cryptocurrency market to slump in a short period.", "https://cointelegraph.com/news/3-reasons-why-bitcoin-suddenly-dipped-under-10k-today-and-recovered", "https://s3.cointelegraph.com/storage/uploads/view/4275d592b2b6ee0bceed726b684d83c5.jpg", "2020-09-05T15:21:00Z", "The price of Bitcoin (BTC) dropped to sub-$10,000 across major exchanges again on Sep. 5, marking two consecutive days of testing the crucial level. Other major cryptocurrencies, including Ethereums … [+3510 chars]"));
        articles.add(new Article(sources, "Cointelegraph By Joseph Young", "3 reasons why Bitcoin suddenly dipped under $10K today — and recovered", "The price of Bitcoin briefly dropped below $10,000, causing the entire cryptocurrency market to slump in a short period.", "https://cointelegraph.com/news/3-reasons-why-bitcoin-suddenly-dipped-under-10k-today-and-recovered", "https://s3.cointelegraph.com/storage/uploads/view/4275d592b2b6ee0bceed726b684d83c5.jpg", "2020-09-05T15:21:00Z", "The price of Bitcoin (BTC) dropped to sub-$10,000 across major exchanges again on Sep. 5, marking two consecutive days of testing the crucial level. Other major cryptocurrencies, including Ethereums … [+3510 chars]"));

        ArrayList<ArticlesData> articlesData=new ArrayList<>();
        articlesData.add(new ArticlesData("ok",5195,articles));
        articlesData.add(new ArticlesData("ok",5195,articles));
        articlesData.add(new ArticlesData("ok",5195,articles));
        articlesData.add(new ArticlesData("ok",5195,articles));
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.news_list_item, articlesData);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);

    }
}