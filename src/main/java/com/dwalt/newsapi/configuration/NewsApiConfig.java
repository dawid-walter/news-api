package com.dwalt.newsapi.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NewsApiConfig {
    @Value("${news.api.key}")
    private String newsApiKey;
    @Value("${news.api.url}")
    private String newsApiUrl;
}
