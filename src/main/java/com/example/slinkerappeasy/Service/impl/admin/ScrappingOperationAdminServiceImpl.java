package com.example.slinkerappeasy.Service.impl.admin;



import com.example.slinkerappeasy.Bean.ScrappingOperation;
import com.example.slinkerappeasy.Bean.WebSite;
import com.example.slinkerappeasy.Dao.ScrappingOperationDao;
import com.example.slinkerappeasy.Service.facade.admin.ScrappingOperationAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScrappingOperationAdminServiceImpl implements ScrappingOperationAdminService {
    @Autowired
    private ScrappingOperationItemAdminServiceImpl scrappingOperationItemAdminServiceImpl;

    @Override
    public List<ScrappingOperation> findByAffliateId(Long id) {
        return scrappingOperationDao.findByAffliateId(id);
    }

    @Override
    public int deleteByAffliateId(Long id) {
        return scrappingOperationDao.deleteByAffliateId(id);
    }

    @Override
    public List<ScrappingOperation> findByWebSiteId(Long id) {
        return scrappingOperationDao.findByWebSiteId(id);
    }

    @Override
    public int deleteByWebSiteId(Long id) {
        return scrappingOperationDao.deleteByWebSiteId(id);
    }

    public List<ScrappingOperation> findAll() {
        return scrappingOperationDao.findAll();
    }
    public int save(ScrappingOperation scrappingOperation){
        scrappingOperationDao.save(scrappingOperation);
        scrappingOperationItemAdminServiceImpl.save(scrappingOperation , scrappingOperation.getScrappingOperationItems());
        return 1;
    }
    public int update(ScrappingOperation scrappingOperation){
        if (scrappingOperationDao.findById(scrappingOperation.getId())==null){
            return -1;
        }
        ScrappingOperation scrappingOperation1=scrappingOperationDao.findById(scrappingOperation.getId()).orElse(null);
        scrappingOperation1.setAffliate(scrappingOperation.getAffliate());
        scrappingOperation1.setDateDebutScrappingOperation(scrappingOperation.getDateDebutScrappingOperation());
        scrappingOperation1.setDateFinScrappingOperation(scrappingOperation.getDateFinScrappingOperation());
        scrappingOperation1.setUrl(scrappingOperation.getUrl());
        scrappingOperation1.setWebSite(scrappingOperation.getWebSite());
        scrappingOperationItemAdminServiceImpl.deleteByScrappingOperationId(scrappingOperation.getId());
        scrappingOperationItemAdminServiceImpl.save(scrappingOperation1 , scrappingOperation.getScrappingOperationItems());
        return 1;
    }

    @Autowired
    private ScrappingOperationDao scrappingOperationDao;

}