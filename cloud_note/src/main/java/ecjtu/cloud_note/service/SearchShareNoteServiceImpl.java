package ecjtu.cloud_note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import ecjtu.cloud_note.dao.ShareDao;
import ecjtu.cloud_note.entity.Share;
import ecjtu.cloud_note.util.NoteResult;

@Repository("searchShareNoteService")
public class SearchShareNoteServiceImpl implements SearchShareNoteService {
	@Resource
	private ShareDao shareDao;
	
	public NoteResult<List<Share>> findShareNote(String keyword,int page) {
		NoteResult<List<Share>> result = new NoteResult<List<Share>>();
		int begin = (page-1)*3;//计算抓取记录的起点
		
		//模糊查询
		String title = "%"+keyword+"%";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("title",title);
		params.put("begin", begin);
		//System.out.println(title);
		List<Share> list = shareDao.search(params);
		//System.out.println(list);
		result.setStatus(0);
		result.setMsg("笔记查询成功");
		result.setData(list);
		return result;
	}
	
}





