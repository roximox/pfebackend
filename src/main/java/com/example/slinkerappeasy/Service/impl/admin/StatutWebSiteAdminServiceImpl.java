package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.StatutWebSite;
import com.example.slinkerappeasy.Dao.StatutWebSiteDao;
import com.example.slinkerappeasy.Service.facade.admin.StatutWebSiteAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutWebSiteAdminServiceImpl  implements StatutWebSiteAdminService {
    public StatutWebSite findByCode(String code) {
        return statutWebSiteDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return statutWebSiteDao.deleteByCode(code);
    }

    public List<StatutWebSite> findAll() {
        return statutWebSiteDao.findAll();
    }

    public int save(StatutWebSite statutWebSite){
        if (findByCode(statutWebSite.getCode())!=null){
            return -1;
        }
        statutWebSiteDao.save(statutWebSite);
        return 1;
    }
    public int update(StatutWebSite statutWebSite){
        if (findByCode(statutWebSite.getCode())==null){
            return -1;
        }
        StatutWebSite statutWebSite1 = findByCode(statutWebSite.getCode());
        statutWebSite1.setLibelle(statutWebSite.getLibelle());
        statutWebSiteDao.save(statutWebSite1);
        return 1;
    }
    @Autowired
    private StatutWebSiteDao statutWebSiteDao;

}