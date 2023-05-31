package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.ScrappingLink;
import com.example.slinkerappeasy.Dao.ScrappingLinkDao;
import com.example.slinkerappeasy.Service.facade.admin.ScrappingLinkAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrappingLinkAdminServiceImpl  implements ScrappingLinkAdminService {

    @Autowired
    private WebSiteAdminServiceImpl webSiteAdminServiceImpl;

    public ScrappingLink findByCode(String code) {
        return scrappingLinkDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return scrappingLinkDao.deleteByCode(code);
    }

    @Override
    public List<ScrappingLink> findByWebSiteId(Long id) {
        return scrappingLinkDao.findByWebSiteId(id);
    }

    @Override
    public int deleteByWebSiteId(Long id) {
        return scrappingLinkDao.deleteByWebSiteId(id);
    }

    public List<ScrappingLink> findAll() {
        return scrappingLinkDao.findAll();
    }
    public int save(ScrappingLink scrappingLink){
        if (findByCode(scrappingLink.getCode())!=null){
            return -1;
        }
        scrappingLinkDao.save(scrappingLink);
        return 1;
    }
    public int update(ScrappingLink scrappingLink){
        if (scrappingLinkDao.findById(scrappingLink.getId())==null){
            return -1;
        }
        ScrappingLink scrappingLink1= scrappingLinkDao.findById(scrappingLink.getId()).orElse(null);
        scrappingLink1.setWebSite(scrappingLink.getWebSite());
        scrappingLink1.setLibelle(scrappingLink.getLibelle());
        scrappingLink1.setCode(scrappingLink.getCode());
        return 1;
    }

    @Autowired
    private ScrappingLinkDao scrappingLinkDao;

}