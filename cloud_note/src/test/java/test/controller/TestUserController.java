package test.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ecjtu.cloud_note.controller.UserLoginController;
import ecjtu.cloud_note.controller.UserRegistController;
import ecjtu.cloud_note.entity.User;
import ecjtu.cloud_note.service.UserService;
import ecjtu.cloud_note.util.NoteResult;

public class TestUserController {
	private ApplicationContext ac;
	@Before
	public void init() {
		String[] conf = {"conf/spring-mybatis.xml",
						 "conf/spring-mvc.xml"};
		ac = new ClassPathXmlApplicationContext(conf);
			
		
	}
	/*@Test
	public void test1() {
		UserLoginController controller = ac.getBean("userLoginController",UserLoginController.class);
		NoteResult<User> result = controller.userLoginController("demo", "123");
		
	}*/
	@Test
	public void test2() {
		UserRegistController controller = ac.getBean("userRegistController",UserRegistController.class);
		NoteResult<Object> result = controller.userRegistController("demo2", "111", "111111");
		System.out.println(result);
	}
	
}






