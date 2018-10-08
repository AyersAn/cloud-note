package ecjtu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ecjtu.cloud_note.service.DeleteNoteService;
import ecjtu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/delete")
public class DeleteNoteController {
	@Resource
	private DeleteNoteService service;
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public NoteResult<Object> execute(String noteId){
		NoteResult<Object> result = service.deleteNoteService(noteId);
		return result;
	}
}








