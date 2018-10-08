package ecjtu.cloud_note.service;

import java.util.List;
import java.util.Map;

import ecjtu.cloud_note.entity.Note;
import ecjtu.cloud_note.util.NoteResult;

public interface NoteService {
	public NoteResult<List<Map>> loadBookNotes(String bookId);
	
	public NoteResult<Note> loadNote(String noteId);
	
	public NoteResult<Object> updateNote(Note note);
	
	public NoteResult<Note> addNote(String cn_note_title,String cn_notebook_id,String cn_user_id);
	//String... :动态参数,就是String[]数组
	public void deleteNotes(String...ids);
}
