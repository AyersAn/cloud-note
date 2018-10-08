package ecjtu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ecjtu.cloud_note.service.ShareNoteService;
import ecjtu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class AddShareController {
	@Resource
	private ShareNoteService service;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(String noteId){
		//接受返回结果
		NoteResult<Object> result = service.addShareNote(noteId);
		
		return result;
		
	}
}






