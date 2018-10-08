package ecjtu.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import ecjtu.cloud_note.dao.DeleteNoteDao;
import ecjtu.cloud_note.util.NoteResult;
@Repository("deleteNoteService")
public class DeleteNoteServiceImpl implements DeleteNoteService {
	@Resource
	private DeleteNoteDao deleteNoteDao;
	
	public NoteResult<Object> deleteNoteService(String noteId) {
		//返回结果
		deleteNoteDao.delete(noteId);
		NoteResult<Object> result = new NoteResult<Object>();
		result.setStatus(0);
		result.setMsg("笔记删除成功");
		return result;
	}

}
