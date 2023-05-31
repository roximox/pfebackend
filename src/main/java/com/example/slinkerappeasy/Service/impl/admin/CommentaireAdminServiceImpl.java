package com.example.slinkerappeasy.Service.impl.admin;



import com.example.slinkerappeasy.Bean.Article;
import com.example.slinkerappeasy.Bean.Commentaire;
import com.example.slinkerappeasy.Dao.CommentaireDao;
import com.example.slinkerappeasy.Service.facade.admin.CommentaireAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentaireAdminServiceImpl  implements CommentaireAdminService {

    @Override
    public List<Commentaire> findByArticleId(Long id) {
        return commentaireDao.findByArticleId(id);
    }

    @Override
    public int deleteByArticleId(Long id) {
        return commentaireDao.deleteByArticleId(id);
    }

    @Override
    public int save(Article article, List<Commentaire> commentaires) {
        for (Commentaire commentaire:commentaires){
            commentaire.setArticle(article);
            commentaire.setDateCommentaire(LocalDateTime.now());
            commentaireDao.save(commentaire);
        }
        return 1;
    }

    public List<Commentaire> findAll() {
        return commentaireDao.findAll();
    }

    @Autowired
    private CommentaireDao commentaireDao;

}