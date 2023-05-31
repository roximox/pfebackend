package com.example.slinkerappeasy.Service.impl.admin;



import com.example.slinkerappeasy.Bean.ScrappingOperation;
import com.example.slinkerappeasy.Bean.ScrappingOperationItem;
import com.example.slinkerappeasy.Dao.ScrappingOperationDao;
import com.example.slinkerappeasy.Dao.ScrappingOperationItemDao;
import com.example.slinkerappeasy.Service.facade.admin.ScrappingOperationItemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrappingOperationItemAdminServiceImpl  implements ScrappingOperationItemAdminService {


    @Override
    public List<ScrappingOperationItem> findByScrappingLinkId(Long id) {
        return scrappingOperationItemDao.findByScrappingLinkId(id);
    }

    @Override
    public int deleteByScrappingLinkId(Long id) {
        return scrappingOperationItemDao.deleteByScrappingLinkId(id);
    }

    @Override
    public List<ScrappingOperationItem> findByTypeProduitId(Long id) {
        return scrappingOperationItemDao.findByTypeProduitId(id);
    }

    @Override
    public int deleteByTypeProduitId(Long id) {
        return scrappingOperationItemDao.deleteByTypeProduitId(id);
    }

    @Override
    public List<ScrappingOperationItem> findByScrappingOperationId(Long id) {
        return scrappingOperationItemDao.findByScrappingOperationId(id);
    }

    @Override
    public int deleteByScrappingOperationId(Long id) {
        return scrappingOperationItemDao.deleteByScrappingOperationId(id);
    }

    public List<ScrappingOperationItem> findAll() {
        return scrappingOperationItemDao.findAll();
    }
    public int save(ScrappingOperation scrappingOperation , List<ScrappingOperationItem> scrappingOperationItems){
        for (ScrappingOperationItem scrappingOperationItem: scrappingOperationItems){
            scrappingOperationItem.setScrappingOperation(scrappingOperation);
            scrappingOperationItemDao.save(scrappingOperationItem);

        }
        return 1;
    }

    @Autowired
    private ScrappingOperationItemDao scrappingOperationItemDao;

}