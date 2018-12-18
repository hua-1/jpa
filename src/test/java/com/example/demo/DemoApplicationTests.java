package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserDaoRepository;
import com.example.demo.entity.UserDO;
import com.example.demo.utils.ThreadPoolUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserDaoRepository userDaoRepository;
	@Test
	public void contextLoads() {
		UserDO userDO = new UserDO();
		userDO.setName("风清扬");
		userDao.save(userDO);

	}

	@Test
	public void add(){
		ExecutorService threadPool = ThreadPoolUtils.getThreadPool();
		threadPool.submit(new Runnable() {
			@Override
			public void run() {
				contextLoads();
			}
		});
	}


	@Test
	public void getUserById(){
		List<UserDO> userDOS = userDao.searchList("风");
		System.out.println(userDOS.size());
	}

	@Test
	public void crud(){
		Optional<UserDO> byId = userDao.findById(3L);
		boolean present = byId.isPresent();
		System.out.println(present);
		if (byId==null){
			System.out.println(123);
		}
	}
}

