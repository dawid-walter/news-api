package com.dwalt.newsapi.service;

import com.dwalt.newsapi.client.NewsClient;
import com.dwalt.newsapi.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private NewsClient newsClient;

    @Autowired
    public NewsService(NewsClient newsClient) {
        this.newsClient = newsClient;
    }

    public List<News> getNews() {
        return newsClient.getNews();
    }
}
