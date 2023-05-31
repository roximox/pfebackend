package com.example.slinkerappeasy.Bean;


import javax.persistence.*;

@Entity
public class Notification    {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500)
    private String description;
    @ManyToOne
    private StatutNotification statutNotification ;
    @ManyToOne
    private NotificationDetail notificationDetail ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatutNotification getStatutNotification() {
        return statutNotification;
    }

    public void setStatutNotification(StatutNotification statutNotification) {
        this.statutNotification = statutNotification;
    }

    public NotificationDetail getNotificationDetail() {
        return notificationDetail;
    }

    public void setNotificationDetail(NotificationDetail notificationDetail) {
        this.notificationDetail = notificationDetail;
    }
}

