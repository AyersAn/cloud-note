package test.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.support.DaoSupport;

import ecjtu.cloud_note.entity.Book;
import ecjtu.cloud_note.entity.User;
import ecjtu.cloud_note.service.BookService;
import ecjtu.cloud_note.service.UserService;
import ecjtu.cloud_note.util.NoteResult;
import test.TestBase;

public class TestBookService extends TestBase {
	private BookService service;
	@Before
	public void init() {
		/*ApplicationContext ac = getContext();
		service = ac.getBean("bookService",BookService.class);	
		*/
		service = super.getContext().getBean("bookService",BookService.class);
	}
	@Test //用例-1：预期结果：用户名不存在
	public void test1() {
		NoteResult<List<Book>> result = service.loadUserBooks("52f9b276-38ee-447f-a3aa-0d54e7a736e4");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
		for(Book book : result.getData()) {
			System.out.println(book.getCn_notebook_name());
		}
		
	}
	@Test	//测试增加笔记本
	public void test2() {
		service.addBook("39295a3d-cc9b-42b4-b206-a2e7fab7e77c", "酷酷酷");
	}
	
}






