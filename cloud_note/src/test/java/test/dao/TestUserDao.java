package test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ecjtu.cloud_note.dao.UserDao;
import ecjtu.cloud_note.entity.User;

public class TestUserDao {
	
	@Test	//查找用户
	public void test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = dao.findByName("demo");
		System.out.println(user);
	}
	@Test
	public void test2() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		//获取UserDao对象
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = new User();
		user.setCn_user_id("1");
		user.setCn_user_name("张三");
		user.setCn_user_password("123456");
		user.setCn_user_nick("小三");
		dao.save(user);
	}
	@Test	//修改密码
	public void test3() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		User user = new User();
		user.setCn_user_id("111111");
		user.setCn_user_password("123456");
		//获取UserDao对象
		UserDao dao = ac.getBean("userDao",UserDao.class);
		dao.updatePassword(user);
	}
	
	@Test	//按userId查找原密码
	public void test4() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		//获取UserDao对象
		UserDao dao = ac.getBean("userDao",UserDao.class);
		System.out.println(dao.findByUserId("111111"));
	}
}










