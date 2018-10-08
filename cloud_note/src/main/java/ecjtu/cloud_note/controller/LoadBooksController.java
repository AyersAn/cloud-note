package ecjtu.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ecjtu.cloud_note.entity.Book;
import ecjtu.cloud_note.service.BookService;
import ecjtu.cloud_note.util.NoteResult;
@Controller
@RequestMapping("/book")
public class LoadBooksController {
	@Resource
	private BookService service;
	@RequestMapping("/loadBooks.do")
	@ResponseBody
	public NoteResult<List<Book>> execute(String userId){
		//int[] a = {8,0,5,5};
		//System.out.println(a[7]);
		NoteResult<List<Book>> result = service.loadUserBooks(userId);
		
		return result;
	}
}





