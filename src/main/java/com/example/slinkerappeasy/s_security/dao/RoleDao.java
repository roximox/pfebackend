package com.example.slinkerappeasy.s_security.dao;


import com.example.slinkerappeasy.s_security.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
