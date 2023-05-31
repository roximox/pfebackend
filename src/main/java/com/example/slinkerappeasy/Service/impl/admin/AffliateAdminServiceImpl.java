package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.Affliate;
import com.example.slinkerappeasy.Dao.AffliateDao;
import com.example.slinkerappeasy.Service.facade.admin.AffliateAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AffliateAdminServiceImpl implements AffliateAdminService {


    @Override
    public Affliate findByCode(String code) {
        return affliateDao.findByCode(code);
    }

    @Transactional
    @Override
    public int deleteByCode(String code) {
        return affliateDao.deleteByCode(code);
    }

    @Override
    public List<Affliate> findByClientId(Long id) {
        return affliateDao.findByClientId(id);
    }

    @Override
    public int deleteByClientId(Long id) {
        return affliateDao.deleteByClientId(id);
    }

    public List<Affliate> findAll() {
        return affliateDao.findAll();
    }
    public int update(Affliate t) {
        Affliate loadedItem = affliateDao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            return-1;
        } else {
            loadedItem.setClient(t.getClient());
            loadedItem.setCode(t.getCode());
            loadedItem.setLibelle(t.getLibelle());
            affliateDao.save(loadedItem);
            return 1;
        }
    }
    public int save (Affliate affliate){
        if (findByCode(affliate.getCode())!=null){
            return -1;
        }
        affliate.setClient(clientService.findById(affliate.getClient().getId()));
        affliateDao.save(affliate);
        return 1;


    }
    @Autowired
    private AffliateDao affliateDao;
    @Autowired
    private ClientAdminServiceImpl clientService;

}