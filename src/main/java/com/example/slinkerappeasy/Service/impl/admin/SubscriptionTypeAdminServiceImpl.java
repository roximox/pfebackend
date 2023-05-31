package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.SubscriptionType;
import com.example.slinkerappeasy.Dao.SubscriptionTypeDao;
import com.example.slinkerappeasy.Service.facade.admin.SubscriptionTypeAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionTypeAdminServiceImpl  implements SubscriptionTypeAdminService {

  @Autowired
    private  SubscriptionTypeDao subscriptionTypeDao;



    public SubscriptionType findByReferenceEntity(SubscriptionType t){
        return  subscriptionTypeDao.findByCode(t.getCode());
    }


    @Override
    public SubscriptionType findByCode(String code) {
        return subscriptionTypeDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return subscriptionTypeDao.deleteByCode(code);
    }
    public int save(SubscriptionType subscriptionType){
        if (findByCode(subscriptionType.getCode())!=null){
            return -1;
        }
        subscriptionTypeDao.save(subscriptionType);
        return 1;
    }
    public int update(SubscriptionType subscriptionType){
        if (findByCode(subscriptionType.getCode())==null){
            return -1;
        }
        SubscriptionType subscriptionType1 = findByCode(subscriptionType.getCode());
        subscriptionType1.setLibelle(subscriptionType.getLibelle());
        subscriptionTypeDao.save(subscriptionType1);
        return 1;
    }
}