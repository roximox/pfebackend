package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.WebSite;

import java.util.List;

public interface WebSiteAdminService   {

    List<WebSite> findByStatutWebSiteId(Long id);
    int deleteByStatutWebSiteId(Long id);
    List<WebSite> findByClientsId(Long id);
    int deleteByClientsId(Long id);
    WebSite findById(Long id);


}
