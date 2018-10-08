package ecjtu.cloud_note.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import ecjtu.cloud_note.entity.Book;
@Repository("bookDao")
public interface BookDao {
	public List<Book> findByUserId(String id);
	
	public void save(@Param("bookId")String bookId,@Param("userId")String userId,
			@Param("bookName")String bookName,@Param("createTime")String createTime);
}






