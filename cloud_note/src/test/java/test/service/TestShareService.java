package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ecjtu.cloud_note.entity.Share;
import ecjtu.cloud_note.service.SearchShareNoteService;
import ecjtu.cloud_note.service.ShareNoteService;
import ecjtu.cloud_note.util.NoteResult;
import test.TestBase;

public class TestShareService extends TestBase {
	
	private ShareNoteService service;
	private SearchShareNoteService searchService;
	@Before
	public void init() {
		service = super.getContext().getBean("shareNoteService",ShareNoteService.class);
		searchService = super.getContext().getBean("searchShareNoteService",SearchShareNoteService.class);
	}
	@Test	//测试分享笔记
	public void test1() {
		System.out.println(service.addShareNote("mmm"));
	}
	
	@Test //测试搜索共享笔记
	public void test2() {
		
	}
}





