package com.example.slinkerappeasy.Service.facade.admin;


import com.example.slinkerappeasy.Bean.TypeProduit;

public interface TypeProduitAdminService  {


    TypeProduit findByCode(String code);
    int deleteByCode(String code);



}
