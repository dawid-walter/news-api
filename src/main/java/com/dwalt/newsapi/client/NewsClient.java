package com.dwalt.newsapi.client;

import com.dwalt.newsapi.configuration.NewsApiConfig;
import com.dwalt.newsapi.domain.News;
import com.dwalt.newsapi.domain.NewsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class NewsClient {
    RestTemplate restTemplate;
    NewsApiConfig newsApiConfig;

    @Autowired
    public NewsClient(RestTemplate restTemplate, NewsApiConfig newsApiConfig) {
        this.restTemplate = restTemplate;
        this.newsApiConfig = newsApiConfig;
    }

    public List<News> getNews() {
        NewsList forObject = restTemplate.getForObject(getNewsUrl(), NewsList.class);
        return forObject.getNewsList();
    }

    private URI getNewsUrl() {
        return UriComponentsBuilder.fromHttpUrl(newsApiConfig.getNewsApiUrl())
                .queryParam("language", "pl")
                .queryParam("apiKey", newsApiConfig.getNewsApiKey())
                .build().encode().toUri();
    }
}
