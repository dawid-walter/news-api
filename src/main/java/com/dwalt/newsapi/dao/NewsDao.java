package com.dwalt.newsapi.dao;

import com.dwalt.newsapi.domain.News;

import java.util.List;

public interface NewsDao {
    void save(String title, String description);

    List<News> findAll();

    News findById(long id);

    void update(News news);

    void deleteAll();

    void deleteById(long id);
}
