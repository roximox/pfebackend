package com.example.slinkerappeasy.ws;



import com.example.slinkerappeasy.Bean.Article;
import com.example.slinkerappeasy.Bean.Commentaire;
import com.example.slinkerappeasy.Service.impl.admin.CommentaireAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/commentaire/")
public class CommentaireRestAdmin {

@GetMapping("article/id/{id}")
    public List<Commentaire> findByArticleId(@PathVariable Long id) {
        return commentaireAdminService.findByArticleId(id);
    }
@DeleteMapping("article/id/{id}")
    public int deleteByArticleId(@PathVariable Long id) {
        return commentaireAdminService.deleteByArticleId(id);
    }
@PostMapping("")
    public int save(@RequestBody Article article, @RequestBody List<Commentaire> commentaires) {
        return commentaireAdminService.save(article, commentaires);
    }
@GetMapping("")
    public List<Commentaire> findAll() {
        return commentaireAdminService.findAll();
    }

    @Autowired
    public CommentaireAdminServiceImpl commentaireAdminService;


}