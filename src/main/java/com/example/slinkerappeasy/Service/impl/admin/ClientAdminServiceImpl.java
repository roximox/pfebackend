package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.Client;
import com.example.slinkerappeasy.Dao.*;
import com.example.slinkerappeasy.Service.facade.admin.ClientAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientAdminServiceImpl implements ClientAdminService {
    @Override
    public List<Client> findByStatutClientId(Long id) {
        return clientDao.findByStatutClientId(id);
    }

    @Override
    public int deleteByStatutClientId(Long id) {
        return clientDao.deleteByStatutClientId(id);
    }

    @Override
    public Client findById(Long id) {
        return clientDao.getOne(id);
    }

    @Override
    public Client findByEmailAndPassword(String email, String password) {
        return clientDao.findByEmailAndPassword(email, password);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }
    public int create(Client t) {
        if (findByEmailAndPassword(t.getEmail() , t.getPassword())!=null){
            return -1;
        }
        clientDao.save(t);

        if (t.getAffliates() != null) {
            t.getAffliates().forEach(element-> {
                element.setClient(t);
                affliateService.save(element);
            });
        }
        if (t.getWebSites() != null) {
            t.getWebSites().forEach(element-> {
              element.getClients().clear();
              element.getClients().add(t);
                webSiteService.save(element);
            });
        }
        if (t.getNotificationDetails() != null) {
            t.getNotificationDetails().forEach(element-> {
                element.setClient(t);
                notificationDetailService.save(element);
            });
        }
        if (t.getSubscriptions() != null) {
            t.getSubscriptions().forEach(element-> {
                element.setClient(t);
                subscriptionService.save(element);
            });
        }
        return 1;
    }

    @Autowired
    public ClientDao clientDao;
    @Autowired
    public AffliateAdminServiceImpl affliateService;
    @Autowired
    public WebSiteAdminServiceImpl webSiteService;
    @Autowired
    public NotificationDetailAdminServiceImpl notificationDetailService;
    @Autowired
    public SubscriptionAdminServiceImpl subscriptionService;


    @Override
    public int deleteByWebSitesId(Long id) {
        return clientDao.deleteByWebSitesId(id);
    }
}