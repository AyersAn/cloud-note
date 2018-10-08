package ecjtu.cloud_note.service;

import ecjtu.cloud_note.util.NoteResult;

public interface ShareNoteService {
	public NoteResult<Object> addShareNote(String noteId);
}
