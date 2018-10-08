package ecjtu.cloud_note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ecjtu.cloud_note.entity.Note;
import ecjtu.cloud_note.service.NoteService;
import ecjtu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadNoteController {
	@Resource
	private NoteService service;
	@RequestMapping("/loadnotes.do")
	@ResponseBody
	public NoteResult<List<Map>> execute(String bookId){
		NoteResult<List<Map>> result = service.loadBookNotes(bookId);
		return result;
	}
	
	@RequestMapping("/load.do")
	@ResponseBody
	public NoteResult<Note> findNote(String noteId){
		NoteResult<Note> result = service.loadNote(noteId);
		return result;
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult<Object> updateNote(String noteId,String noteTitle,String noteBody){
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_body(noteBody);
		note.setCn_note_title(noteTitle);
		
		NoteResult<Object> result = service.updateNote(note);
		return result;
	}
	
}






