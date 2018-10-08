package test.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ecjtu.cloud_note.dao.NoteDao;
import ecjtu.cloud_note.dao.ShareDao;
import ecjtu.cloud_note.entity.Share;
import test.TestBase;

public class TestShareDao extends TestBase {
	private ShareDao dao;
	@Before
	public void init() {
		dao = super.getContext().getBean("shareDao",ShareDao.class);
	}
	@Test	//测试分享笔记的dao层
	public void test1() {
		Share share = new Share();
		share.setCn_note_id("ss19055-30e8-4cdc-bfac-97c6bad9518f");
		share.setCn_share_body("QQQ");
		share.setCn_share_id("AAA");
		share.setCn_share_title("QQQ");
		dao.save(share);
	}
	
	
}





