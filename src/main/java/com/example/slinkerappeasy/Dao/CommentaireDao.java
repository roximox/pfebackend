package com.example.slinkerappeasy.Dao;


import com.example.slinkerappeasy.Bean.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentaireDao extends JpaRepository<Commentaire,Long> {

    List<Commentaire> findByArticleId(Long id);
    int deleteByArticleId(Long id);

}
