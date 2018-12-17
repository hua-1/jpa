package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserDao userDao;
	@Test
	public void contextLoads() {
		UserDO userDO = new UserDO();
		userDO.setId(1L);
		userDO.setName("风清扬");
		userDao.save(userDO);

	}

	@Test
	public void getUserById(){
		UserDO userDO = userDao.findById(2L).orElse(null);
		if (userDO==null){
			System.out.println("结果为空啊");
		}
		System.out.println(userDO.getName());
	}

}

