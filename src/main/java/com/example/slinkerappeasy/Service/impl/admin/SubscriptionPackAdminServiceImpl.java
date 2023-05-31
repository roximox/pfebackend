package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.SubscriptionPack;
import com.example.slinkerappeasy.Dao.SubscriptionPackDao;
import com.example.slinkerappeasy.Service.facade.admin.SubscriptionPackAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionPackAdminServiceImpl  implements SubscriptionPackAdminService {

    @Autowired
    private  SubscriptionPackDao subscriptionPackDao;


    public SubscriptionPack findByReferenceEntity(SubscriptionPack t){
        return  subscriptionPackDao.findByCode(t.getCode());
    }
    public int save(SubscriptionPack subscriptionEtat){
        if (findByCode(subscriptionEtat.getCode())!=null){
            return -1;
        }
        subscriptionPackDao.save(subscriptionEtat);
        return 1;
    }
    public int update(SubscriptionPack subscriptionPack){
        if (findByCode(subscriptionPack.getCode())==null){
            return -1;
        }
        SubscriptionPack subscriptionPack1 = findByCode(subscriptionPack.getCode());
        subscriptionPack1.setLibelle(subscriptionPack.getLibelle());
        subscriptionPack1.setPrix(subscriptionPack.getPrix());
        subscriptionPackDao.save(subscriptionPack1);
        return 1;
    }


    @Override
    public SubscriptionPack findByCode(String code) {
        return subscriptionPackDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return subscriptionPackDao.deleteByCode(code);
    }
}