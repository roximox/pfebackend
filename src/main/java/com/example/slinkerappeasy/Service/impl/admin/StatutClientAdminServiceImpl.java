package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.StatutClient;
import com.example.slinkerappeasy.Dao.StatutClientDao;
import com.example.slinkerappeasy.Service.facade.admin.StatutClientAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutClientAdminServiceImpl  implements StatutClientAdminService {

    public StatutClient findByCode(String code) {
        return statutClientDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return statutClientDao.deleteByCode(code);
    }

    public List<StatutClient> findAll() {
        return statutClientDao.findAll();
    }
    public int save(StatutClient statutClient){
        if (findByCode(statutClient.getCode())!=null){
            return -1;
        }
        statutClientDao.save(statutClient);
        return 1;
    }
    public int update(StatutClient statutClient){
        if (findByCode(statutClient.getCode())==null){
            return -1;
        }
        StatutClient statutClient1 = findByCode(statutClient.getCode());
        statutClient1.setLibelle(statutClient.getLibelle());
        statutClientDao.save(statutClient1);
        return 1;
    }

    @Autowired
    private StatutClientDao statutClientDao;

}