package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.StatutNotification;
import com.example.slinkerappeasy.Dao.StatutNotificationDao;
import com.example.slinkerappeasy.Service.facade.admin.StatutNotificationAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutNotificationAdminServiceImpl  implements StatutNotificationAdminService {

    public StatutNotification findByCode(String code) {
        return statutNotificationDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return statutNotificationDao.deleteByCode(code);
    }

    public List<StatutNotification> findAll() {
        return statutNotificationDao.findAll();
    }
      public int save(StatutNotification statutNotification){
            if (findByCode(statutNotification.getCode())!=null){
                return -1;
            }
            statutNotificationDao.save(statutNotification);
            return 1;
        }
        public int update(StatutNotification statutNotification){
            if (findByCode(statutNotification.getCode())==null){
                return -1;
            }
            StatutNotification statutNotification1 = findByCode(statutNotification.getCode());
            statutNotification1.setLibelle(statutNotification.getLibelle());
            statutNotificationDao.save(statutNotification1);
            return 1;
        }
    @Autowired
    private StatutNotificationDao statutNotificationDao;
}