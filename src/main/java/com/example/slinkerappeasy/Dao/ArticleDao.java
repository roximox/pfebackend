package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleDao extends JpaRepository<Article,Long> {

    Article findByTitre(String titre);

}
