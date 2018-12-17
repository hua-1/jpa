package com.example.demo.dao;

import com.example.demo.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserDO, Long> {

}
