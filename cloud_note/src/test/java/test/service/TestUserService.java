package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ecjtu.cloud_note.dao.UserDao;
import ecjtu.cloud_note.entity.User;
import ecjtu.cloud_note.service.UserService;
import ecjtu.cloud_note.util.NoteResult;

public class TestUserService {
	private UserService service;
	@Before
	public void init() {
		String[] conf = {"conf/spring-mybatis.xml",
						 "conf/spring-mvc.xml",
						 "conf/spring-transaction.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		service = ac.getBean("userService",UserService.class);	
		
	}
	/*@Test //用例-1：预期结果：用户名不存在
	public void test1() {
		NoteResult<User> result = service.checkLogin("ddd", "ss");
		System.out.println(service.getClass().getName());
		//System.out.println(result);
	}*/
	/*@Test //用例-2：预期结果：密码错误
	public void test2() {
		NoteResult<User> result = service.checkLogin("demo", "dedd");
		System.out.println(result);
	}
	@Test //用例-3：预期结果：登录成功
	public void test3() {//4QrcOUm6Wau+VuBX8g+IPg==
		NoteResult<User> result = service.checkLogin("demo", "123456");
		System.out.println(result);
	}*/
	
	@Test //用例-4：预期结果：用户名已存在
	public void test4() {
		NoteResult<Object> result = service.addUser("lisi2", "笑死", "123456");
		System.out.println(result);
	}
	@Test //用例-5：预期结果：注册成功
	public void test5() {
		NoteResult<Object> result = service.addUser("wangwu", "小五", "123456");
		System.out.println(result);
	}
	
	@Test //用例-6：预期结果：密码修改成功
	public void test6() {
		NoteResult<User> result = service.changePassword("111111","123456","123123");
		System.out.println(result);
	}
	
}









