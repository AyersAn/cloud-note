package ecjtu.cloud_note.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import ecjtu.cloud_note.dao.BookDao;
import ecjtu.cloud_note.entity.Book;
import ecjtu.cloud_note.util.NoteResult;
import ecjtu.cloud_note.util.NoteUtil;
@Repository("bookService")
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao dao;
	
	public NoteResult<List<Book>> loadUserBooks(String userId) {
		//构建返回结果result
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		List<Book> books = dao.findByUserId(userId);
		//System.out.println(books);
		/*if (books == null) {
			result.setStatus(1);
			result.setMsg("笔记本不存在");
			return result;
		}else {*/
			result.setStatus(0);
			result.setMsg("查找笔记本成功");
			result.setData(books);
			return result;
		//}
		
	}

	public String addBook(String userId, String bookName) {
		//创建bookId
		String bookId = NoteUtil.createId();
		//addCookie(bookId);
		//获得当前系统的时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String createTime = format.format(new Timestamp(System.currentTimeMillis()));
		//返回结果
		dao.save(bookId, userId, bookName, createTime);
		
		return bookId;
	}

}






