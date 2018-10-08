package ecjtu.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecjtu.cloud_note.dao.NoteDao;
import ecjtu.cloud_note.entity.Note;
import ecjtu.cloud_note.util.NoteResult;
import ecjtu.cloud_note.util.NoteUtil;
@Repository("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	private NoteDao dao;
	
	public NoteResult<List<Map>> loadBookNotes(String bookId) {
		List<Map> list = dao.findByBookId(bookId);
		//获得结果集
		NoteResult<List<Map>> result = new NoteResult<List<Map>>();
		/*if (list == null) {
			result.setStatus(1);
			result.setMsg("笔记加载失败");
			return result;
			
		}else {*/
			result.setStatus(0);
			result.setMsg("笔记记载成功");
			result.setData(list);
			return result;
		
		
	}

	public NoteResult<Note> loadNote(String noteId) {
		//设置返回结果
		NoteResult<Note> result = new NoteResult<Note>();
		Note note = dao.findByNoteId(noteId);
		if (note == null) {
			result.setStatus(1);
			result.setMsg("未找到数据");
			return result;
		}
		result.setStatus(0);
		result.setMsg("笔记信息加载成功");
		result.setData(note);
		return result;
	}
	@Transactional
	public NoteResult<Object> updateNote(Note note) {
		NoteResult<Object> result = new NoteResult<Object>();
		int n = dao.updateNote(note);
		if (n == 1) {
			result.setStatus(0);
			result.setMsg("笔记信息更新成功");
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("笔记信息更新失败");
			return result;
		}
	}

	public NoteResult<Note> addNote(String cn_note_title, String cn_notebook_id, String cn_user_id) {
		Note note = new Note();
		note.setCn_note_body("");
		note.setCn_note_create_time(System.currentTimeMillis());
		String cn_note_id = NoteUtil.createId();
		note.setCn_note_id(cn_note_id);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		//状态：1-正常，2-delete
		note.setCn_note_status_id("1");
		note.setCn_note_title(cn_note_title);
		//类型：1-normal,2-collect,3-share
		note.setCn_note_type_id("1");
		note.setCn_notebook_id(cn_notebook_id);
		note.setCn_user_id(cn_user_id);
		dao.save(note);
		NoteResult<Note> result = new NoteResult<Note>();
		result.setStatus(0);
		result.setMsg("笔记创建成功");
		result.setData(note);
		return result;
	}
	@Transactional
	public void deleteNotes(String... ids) {
		//String... 就是String[]
		for(String id : ids) {
			int n = dao.deleteNote(id);
			if (n!=1) {
				//抛出异常触发,事物的回滚!
				throw new RuntimeException("删错了");
			}
		}
		
	}

	

	

}






