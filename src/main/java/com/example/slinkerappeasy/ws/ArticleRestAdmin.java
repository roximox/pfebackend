package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.Article;
import com.example.slinkerappeasy.Service.impl.admin.ArticleAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/article/")
public class ArticleRestAdmin {

@PostMapping("")
    public int create(@RequestBody Article t) {
        return articleAdminService.create(t);
    }
@PutMapping("")
    public int update(@RequestBody Article article) {
        return articleAdminService.update(article);
    }
@GetMapping("titre/{titre}")
    public Article findByTitre(@PathVariable String titre) {
        return articleAdminService.findByTitre(titre);
    }
@GetMapping("")
    public List<Article> findAll() {
        return articleAdminService.findAll();
    }

    @Autowired
    public ArticleAdminServiceImpl articleAdminService;
}