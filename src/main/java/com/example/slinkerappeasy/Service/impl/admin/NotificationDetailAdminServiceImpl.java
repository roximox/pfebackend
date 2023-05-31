package com.example.slinkerappeasy.Service.impl.admin;



import com.example.slinkerappeasy.Bean.NotificationDetail;
import com.example.slinkerappeasy.Dao.NotificationDetailDao;
import com.example.slinkerappeasy.Service.facade.admin.NotificationDetailAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationDetailAdminServiceImpl  implements NotificationDetailAdminService {

    @Autowired
    private ClientAdminServiceImpl clientAdminServiceImpl;

    @Override
    public List<NotificationDetail> findByClientId(Long id) {
        return notificationDetailDao.findByClientId(id);
    }

    @Override
    public int deleteByClientId(Long id) {
        return notificationDetailDao.deleteByClientId(id);
    }

    @Override
    public List<NotificationDetail> findByNotificationId(Long id) {
        return notificationDetailDao.findByNotificationId(id);
    }

    @Override
    public int deleteByNotificationId(Long id) {
        return notificationDetailDao.deleteByNotificationId(id);
    }

    public List<NotificationDetail> findAll() {
        return notificationDetailDao.findAll();
    }
    public int save(NotificationDetail notificationDetail){
        if (notificationDetail.getClient()!=null && notificationDetail.getClient().getId()!=null){
            notificationDetail.setClient(clientAdminServiceImpl.findById(notificationDetail.getClient().getId()));
        }
        notificationDetailDao.save(notificationDetail);
        return 1;
    }
    public int update(NotificationDetail notificationDetail){
        if (notificationDetailDao.findById(notificationDetail.getId())==null){
            return -1;
        }
        NotificationDetail notificationDetail1= notificationDetailDao.findById(notificationDetail.getId()).orElse(null);
        notificationDetail1.setClient(notificationDetail.getClient());
        notificationDetail1.setNotification(notificationDetail.getNotification());
        notificationDetailDao.save(notificationDetail1);
        return 1;
    }

    @Autowired
    private NotificationDetailDao notificationDetailDao;

}