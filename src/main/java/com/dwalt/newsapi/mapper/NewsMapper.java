package com.dwalt.newsapi.mapper;

import com.dwalt.newsapi.domain.News;
import com.dwalt.newsapi.domain.NewsDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsMapper {
    public News mapFromDtoToNews(NewsDto newsDto) {
        return new News(newsDto.getId(), newsDto.getTitle(), newsDto.getDescription());
    }

    public NewsDto mapFromNewsToDto(News news) {
        return new NewsDto(news.getId(), news.getTitle(), news.getDescription());
    }

    public List<NewsDto> mapFromListToDto(List<News> newsList) {
        return newsList.stream().map(this::mapFromNewsToDto).collect(Collectors.toList());
    }
}
