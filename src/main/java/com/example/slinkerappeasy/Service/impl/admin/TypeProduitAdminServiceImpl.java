package com.example.slinkerappeasy.Service.impl.admin;


import com.example.slinkerappeasy.Bean.TypeProduit;
import com.example.slinkerappeasy.Dao.TypeProduitDao;
import com.example.slinkerappeasy.Service.facade.admin.TypeProduitAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeProduitAdminServiceImpl  implements TypeProduitAdminService {

    @Autowired
    private  TypeProduitDao typeProduitDao;

    public TypeProduit findByReferenceEntity(TypeProduit t){
        return  typeProduitDao.findByCode(t.getCode());
    }


    @Override
    public TypeProduit findByCode(String code) {
        return typeProduitDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return typeProduitDao.deleteByCode(code);
    }
    public int save(TypeProduit typeProduit){
        if (findByCode(typeProduit.getCode())!=null){
            return -1;
        }
        typeProduitDao.save(typeProduit);
        return 1;
    }
    public int update(TypeProduit typeProduit){
        if (findByCode(typeProduit.getCode())==null){
            return -1;
        }
        TypeProduit typeProduit1 = findByCode(typeProduit.getCode());
        typeProduit1.setLibelle(typeProduit.getLibelle());
        typeProduitDao.save(typeProduit1);
        return 1;
    }
}