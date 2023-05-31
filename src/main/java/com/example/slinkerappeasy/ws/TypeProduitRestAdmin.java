package com.example.slinkerappeasy.ws;


import com.example.slinkerappeasy.Bean.TypeProduit;
import com.example.slinkerappeasy.Service.impl.admin.TypeProduitAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/typeProduit/")
public class TypeProduitRestAdmin {

@GetMapping("ref/{ref}")
    public TypeProduit findByReferenceEntity(@PathVariable TypeProduit t) {
        return typeProduitAdminService.findByReferenceEntity(t);
    }
@GetMapping("code/{code}")
    public TypeProduit findByCode(@PathVariable String code) {
        return typeProduitAdminService.findByCode(code);
    }
@DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typeProduitAdminService.deleteByCode(code);
    }
@PostMapping("")
    public int save(@RequestBody TypeProduit typeProduit) {
        return typeProduitAdminService.save(typeProduit);
    }
@PutMapping("")
    public int update(@RequestBody TypeProduit typeProduit) {
        return typeProduitAdminService.update(typeProduit);
    }

    @Autowired
    public TypeProduitAdminServiceImpl typeProduitAdminService;

}