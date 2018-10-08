package ecjtu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ecjtu.cloud_note.service.BookService;
import ecjtu.cloud_note.util.NoteResult;

@RequestMapping("/book")
@Controller
public class AddBookController {
	@Resource
	private BookService service;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(String userId,String bookName){
		//返回结果
		NoteResult<Object> result = new NoteResult<Object>();
		String bookId = service.addBook(userId, bookName);
		result.setStatus(0);
		result.setMsg("笔记本增加成功");
		result.setData(bookId);
		return result;
	}
}






