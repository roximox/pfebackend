package com.example.slinkerappeasy.Service.impl.admin;



import com.example.slinkerappeasy.Bean.Notification;
import com.example.slinkerappeasy.Dao.NotificationDao;
import com.example.slinkerappeasy.Service.facade.admin.NotificationAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationAdminServiceImpl  implements NotificationAdminService {

    @Override
    public List<Notification> findByStatutNotificationId(Long id) {
        return notificationDao.findByStatutNotificationId(id);
    }

    @Override
    public int deleteByStatutNotificationId(Long id) {
        return notificationDao.deleteByStatutNotificationId(id);
    }

    @Override
    public List<Notification> findByNotificationDetailId(Long id) {
        return notificationDao.findByNotificationDetailId(id);
    }

    @Override
    public int deleteByNotificationDetailId(Long id) {
        return notificationDao.deleteByNotificationDetailId(id);
    }

    public List<Notification> findAll() {
        return notificationDao.findAll();
    }
    public int save(Notification notification){
        notificationDao.save(notification);
        return 1;
    }
    public int update(Notification notification){
        if (notificationDao.findById(notification.getId())==null){
            return -1;
        }
        Notification notification1 = notificationDao.findById(notification.getId()).orElse(null);
        notification1.setNotificationDetail(notification.getNotificationDetail());
        notification1.setStatutNotification(notification.getStatutNotification());
        notification1.setDescription(notification.getDescription());
        notificationDao.save(notification1);
        return 1;
    }

    @Autowired
   private NotificationDao notificationDao;

}