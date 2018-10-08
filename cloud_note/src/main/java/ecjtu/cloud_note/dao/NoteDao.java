package ecjtu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ecjtu.cloud_note.entity.Note;
import ecjtu.cloud_note.util.NoteResult;

public interface NoteDao {
	public List<Map> findByBookId(String bookId);
	
	public Note findByNoteId(String noteId);
	
	public int updateNote(Note note);
	
	public int updateNoteByMap(Map<String,Object> map);
	
	public void save(Note note);
	
	/*
	 * 批量删除
	 * map 中需要添加两个参数:
	 * map={ids:[id1,id2,id3...],status:2}
	 * ids代表被删除笔记的ID列表
	 * status 代表被删除笔记的状态属性
	 */
	public int deleteNotes(Map<String, Object> map);
	
	int deleteNote(String id);
}



