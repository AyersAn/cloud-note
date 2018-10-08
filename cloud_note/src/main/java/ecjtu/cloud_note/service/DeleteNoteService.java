package ecjtu.cloud_note.service;

import ecjtu.cloud_note.util.NoteResult;

public interface DeleteNoteService {
	public NoteResult<Object> deleteNoteService(String noteId);
}
