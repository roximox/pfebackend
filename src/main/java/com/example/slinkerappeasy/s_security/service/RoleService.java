package com.example.slinkerappeasy.s_security.service;


import com.example.slinkerappeasy.s_security.dao.RoleDao;
import com.example.slinkerappeasy.s_security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
