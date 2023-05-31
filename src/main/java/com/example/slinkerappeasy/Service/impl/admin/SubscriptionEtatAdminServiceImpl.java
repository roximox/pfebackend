package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.SubscriptionEtat;
import com.example.slinkerappeasy.Dao.SubscriptionEtatDao;
import com.example.slinkerappeasy.Service.facade.admin.SubscriptionEtatAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionEtatAdminServiceImpl  implements SubscriptionEtatAdminService {

    public SubscriptionEtat findByCode(String code) {
        return subscriptionEtatDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return subscriptionEtatDao.deleteByCode(code);
    }

    public List<SubscriptionEtat> findAll() {
        return subscriptionEtatDao.findAll();
    }

    public int save(SubscriptionEtat subscriptionEtat){
        if (findByCode(subscriptionEtat.getCode())!=null){
            return -1;
        }
        subscriptionEtatDao.save(subscriptionEtat);
        return 1;
    }
    public int update(SubscriptionEtat subscriptionEtat){
        if (findByCode(subscriptionEtat.getCode())==null){
            return -1;
        }
        SubscriptionEtat subscriptionEtat1 = findByCode(subscriptionEtat.getCode());
        subscriptionEtat1.setLibelle(subscriptionEtat.getLibelle());
        subscriptionEtatDao.save(subscriptionEtat1);
        return 1;
    }

    @Autowired
    private SubscriptionEtatDao subscriptionEtatDao;

}