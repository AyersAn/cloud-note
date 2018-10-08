package ecjtu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import ecjtu.cloud_note.entity.Share;

public interface ShareDao {
	//添加分享笔记
	public void save(Share share);
	//搜索分享笔记
	public List<Share> search(Map params);
}





