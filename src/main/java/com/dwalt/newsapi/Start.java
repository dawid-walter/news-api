package com.dwalt.newsapi;

import com.dwalt.newsapi.client.NewsClient;
import com.dwalt.newsapi.service.NewsDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Start {
    private NewsClient newsClient;
    private NewsDbService newsDbService;

    @Autowired
    public Start(NewsClient newsClient, NewsDbService newsDbService) {
        this.newsClient = newsClient;
        this.newsDbService = newsDbService;

        newsDbService.deleteAll();
        newsClient.getNews().forEach(news -> newsDbService.save(news.getTitle(), news.getDescription()));
    }
}
