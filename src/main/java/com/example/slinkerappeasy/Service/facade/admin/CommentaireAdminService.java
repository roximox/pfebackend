package com.example.slinkerappeasy.Service.facade.admin;



import com.example.slinkerappeasy.Bean.Article;
import com.example.slinkerappeasy.Bean.Commentaire;

import java.util.List;

public interface CommentaireAdminService  {

    List<Commentaire> findByArticleId(Long id);
    int deleteByArticleId(Long id);

    int save(Article article,List<Commentaire>commentaires);



}
