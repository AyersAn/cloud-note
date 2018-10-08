package test.dao;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ecjtu.cloud_note.dao.RelationDao;
import ecjtu.cloud_note.entity.Book;
import ecjtu.cloud_note.entity.User;
import test.TestBase;

public class TestRelationDao extends TestBase {
	private RelationDao rDao;
	@Before
	public void init() {
		rDao = super.getContext().getBean("relationDao",RelationDao.class);
	}
	@Test //测试关联查询
	public void testMany() {
		User user = rDao.findUserAndBooks("111111");
		List<Book> books = user.getBooks();
		//System.out.println(book);
		System.out.println("用户名:"+user.getCn_user_name());
		System.out.println("密码:"+user.getCn_user_password());
		System.out.println("笔记本数量:"+user.getBooks().size());
		for(Book book:books) {
			System.out.print(book.getCn_notebook_name()+",");
		}
	}
	
	@Test	//测试单个对象的关联查询,
	public void testSingle() {
		List<Book> books = rDao.findBookAndUser2();
		for (Book book : books) {
			System.out.println(book.getCn_notebook_name()+","+book.getCn_notebook_createtime());
			if (book.getUser() != null) {
				System.out.println(book.getUser().getCn_user_name());
			}
		}
	}
	
	
	
}








