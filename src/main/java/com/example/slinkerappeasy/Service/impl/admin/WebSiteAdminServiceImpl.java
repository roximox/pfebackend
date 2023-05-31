package com.example.slinkerappeasy.Service.impl.admin;

import com.example.slinkerappeasy.Bean.WebSite;
import com.example.slinkerappeasy.Dao.WebSiteDao;
import com.example.slinkerappeasy.Service.facade.admin.ClientAdminService;
import com.example.slinkerappeasy.Service.facade.admin.ScrappingLinkAdminService;
import com.example.slinkerappeasy.Service.facade.admin.StatutWebSiteAdminService;
import com.example.slinkerappeasy.Service.facade.admin.WebSiteAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WebSiteAdminServiceImpl  implements WebSiteAdminService {

    @Autowired
    private WebSiteDao webSiteDao;


    public int save(WebSite webSite) {
        //ajouter le code
        webSiteDao.save(webSite);
        return 1;
    }


    @Transactional
    public void deleteAssociatedLists(Long id) {
        scrappingLinkService.deleteByWebSiteId(id);
    }


    public int update(WebSite webSite){
        if (findById(webSite.getId())==null){
            return -1;
        }
        WebSite webSite1 = findById(webSite.getId());
        webSite1.setStatutWebSite(webSite.getStatutWebSite());
        webSite1.setLibelle(webSite.getLibelle());
        webSite1.setUrl(webSite.getUrl());
        webSite1.setJsonSummary(webSite.getJsonSummary());
        webSite1.setScrappingLinks(webSite.getScrappingLinks());
        return 1;
    }


    public List<WebSite> findByStatutWebSiteId(Long id){
        return webSiteDao.findByStatutWebSiteId(id);
    }
    public int deleteByStatutWebSiteId(Long id){
        return webSiteDao.deleteByStatutWebSiteId(id);
    }
    public List<WebSite> findByClientsId(Long id){
        return webSiteDao.findByClientsId(id);
    }
    public int deleteByClientsId(Long id){
        return webSiteDao.deleteByClientsId(id);
    }

    @Override
    public WebSite findById(Long id) {
        return webSiteDao.getOne(id);
    }


    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private StatutWebSiteAdminService statutWebSiteService ;
    @Autowired
    private ScrappingLinkAdminService scrappingLinkService ;


}