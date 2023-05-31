package com.example.slinkerappeasy.Service.impl.admin;



import com.example.slinkerappeasy.Bean.Article;
import com.example.slinkerappeasy.Bean.Commentaire;
import com.example.slinkerappeasy.Dao.ArticleDao;
import com.example.slinkerappeasy.Service.facade.admin.ArticleAdminService;
import com.example.slinkerappeasy.Service.facade.admin.CommentaireAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleAdminServiceImpl  implements ArticleAdminService {
    public int create(Article t) {
        if (findByTitre(t.getTitre())!=null){
            return -1;
        }
        articleDao.save(t);
        commentaireAdminService.save(t,t.getCommentaires());
        return 1;
    }
    public int update(Article article){
        if(articleDao.findById(article.getId())==null) {
            return -1;
        }
        Article article1 = articleDao.findById(article.getId()).orElse(null);
        article1.setContenu(article.getContenu());
        article1.setTitre(article.getTitre());
        commentaireAdminService.deleteByArticleId(article.getId());
        articleDao.save(article1);
        commentaireAdminService.save(article1 ,article.getCommentaires());
        return 1;
    }


    @Override
    public Article findByTitre(String titre) {
        return articleDao.findByTitre(titre);
    }

    public List<Article> findAll() {
        return articleDao.findAll();
    }

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CommentaireAdminService commentaireAdminService;
}