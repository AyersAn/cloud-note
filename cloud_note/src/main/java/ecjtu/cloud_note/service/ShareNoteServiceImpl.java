package ecjtu.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ecjtu.cloud_note.dao.NoteDao;
import ecjtu.cloud_note.dao.ShareDao;
import ecjtu.cloud_note.entity.Note;
import ecjtu.cloud_note.entity.Share;
import ecjtu.cloud_note.util.NoteResult;
import ecjtu.cloud_note.util.NoteUtil;

@Repository("shareNoteService")
@Transactional
public class ShareNoteServiceImpl implements ShareNoteService {
	@Resource
	private NoteDao noteDao;
	@Resource
	private ShareDao shareDao;
	
	public NoteResult<Object> addShareNote(String noteId) {
		//找到note
		Note note = noteDao.findByNoteId(noteId);
		Share share = new Share();
		//给share赋值
		share.setCn_note_id(noteId);
		share.setCn_share_body(note.getCn_note_body());
		share.setCn_share_id(NoteUtil.createId());
		share.setCn_share_title(note.getCn_note_title());
		//保存分享记录
		shareDao.save(share);
		//模拟异常
		/*String str = null;
		str.length();*/
		//构建返回结果
		NoteResult<Object> result = new NoteResult<Object>();
		result.setStatus(0);
		result.setMsg("分享成功");
		
		return result;
	}

}







