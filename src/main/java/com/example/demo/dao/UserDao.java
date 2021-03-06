package com.example.demo.dao;

import com.example.demo.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<UserDO, Long> {
    @Query("select u from UserDO u where u.name like ?1%")
    List<UserDO> searchList(String name);

}
