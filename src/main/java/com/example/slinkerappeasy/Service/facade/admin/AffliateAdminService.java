package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.Affliate;

import java.util.List;

public interface AffliateAdminService  {
    Affliate findByCode(String code);

    int deleteByCode(String code);

    List<Affliate> findByClientId(Long id);
    int deleteByClientId(Long id);



}
