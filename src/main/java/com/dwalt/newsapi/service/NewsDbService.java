package com.dwalt.newsapi.service;

import com.dwalt.newsapi.dao.NewsDao;
import com.dwalt.newsapi.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDbService implements NewsDao {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsDbService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String title, String description) {
        String sql = "INSERT INTO news (title, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, title, description);
    }

    @Override
    public List<News> findAll() {
        String sql = "SELECT * FROM news";
        RowMapper<News> rowMapper = (resultSet, i) -> new News(resultSet.getLong("id"),
                resultSet.getString("title"),
                resultSet.getString("description"));
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public News findById(long id) {
        String sql = "SELECT * FROM news WHERE news.id=?";
        return jdbcTemplate.queryForObject(sql,
                (resultSet, i) -> new News(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("url")),
                id);
    }

    @Override
    public void update(News news) {
        String sql = "UPDATE news SET news.title=?, news.description=? WHERE news.id=?";
        jdbcTemplate.update(sql, news.getTitle(), news.getDescription(), news.getId());
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM news";
        jdbcTemplate.update(sql);
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM news WHERE news.id=?";
        jdbcTemplate.update(sql, id);
    }
}
