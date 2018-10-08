package ecjtu.cloud_note.service;

import java.util.List;

import ecjtu.cloud_note.entity.Share;
import ecjtu.cloud_note.util.NoteResult;

public interface SearchShareNoteService {
	public NoteResult<List<Share>> findShareNote(String keyword,int page);
}



