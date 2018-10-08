package ecjtu.cloud_note.service;

import java.util.List;

import ecjtu.cloud_note.entity.Book;
import ecjtu.cloud_note.util.NoteResult;


public interface BookService {
	public NoteResult<List<Book>> loadUserBooks(String userId);
	
	public String addBook(String userId,String bookName);
}
