package com.dwalt.newsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NewsDto {
    private long id;
    private String title;
    private String description;
}
