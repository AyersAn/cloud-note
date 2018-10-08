package test.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.apache.tomcat.jni.Local;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.bcel.internal.generic.NEW;

import ecjtu.cloud_note.dao.BookDao;
import ecjtu.cloud_note.entity.Book;
import sun.security.jca.GetInstance.Instance;

public class TestBookDao {
	private BookDao dao;
	@Before
	public void init() {
		String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("bookDao",BookDao.class);
	}
	@Test
	public void test1() {
		
		List<Book> books = dao.findByUserId("52f9b276-38ee-447f-a3aa-0d54e7a736e4");
		for(Book book : books) {
			System.out.println(book);
		}
	}
	@Test	//测试增加笔记本
	public void test2() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String timestamp = df.format(new Timestamp(System.currentTimeMillis()));
		
		dao.save("hhhh","hhhhh", "ffff",timestamp);
	}
}







