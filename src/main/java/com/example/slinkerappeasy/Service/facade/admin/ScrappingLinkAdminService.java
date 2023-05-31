package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.ScrappingLink;

import java.util.List;

public interface ScrappingLinkAdminService   {

    List<ScrappingLink> findByWebSiteId(Long id);
    int deleteByWebSiteId(Long id);



}
