package com.example.slinkerappeasy.s_security.dao;


import com.example.slinkerappeasy.s_security.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
