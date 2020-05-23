package com.dwalt.newsapi.controller;

import com.dwalt.newsapi.domain.NewsDto;
import com.dwalt.newsapi.mapper.NewsMapper;
import com.dwalt.newsapi.service.NewsDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin("*")
public class NewsController {
    private NewsDbService newsDbService;
    private NewsMapper newsMapper;


    @Autowired
    public NewsController(NewsDbService newsDbService, NewsMapper newsMapper) {
        this.newsDbService = newsDbService;
        this.newsMapper = newsMapper;
    }

    @GetMapping
    public List<NewsDto> getNews() {
        return newsMapper.mapFromListToDto(newsDbService.findAll());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        newsDbService.deleteById(id);
    }
}
