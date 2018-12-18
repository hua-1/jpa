package com.example.demo.dao;

import com.example.demo.entity.UserDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserDaoRepository extends CrudRepository<UserDO, Long> {

    @Query("select u from UserDO u where u.name like ?1%")
    List<UserDO> searchList(String name);
}
