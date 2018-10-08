package test.service;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ecjtu.cloud_note.entity.Note;
import ecjtu.cloud_note.service.NoteService;
import ecjtu.cloud_note.util.NoteResult;
import test.TestBase;

public class TestNoteService extends TestBase {
	private NoteService service;
	@Before
	public void init() {
		service = super.getContext().getBean("noteService",NoteService.class);
	}
	@Test
	public void test1() {
		NoteResult<List<Map>> result = service.loadBookNotes("fa8d3d9d-2de5-4cfe-845f-951041bcc461");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
	}
	
	@Test	//测试笔记信息加载的service层
	public void test2() {
		NoteResult<Note> result = service.loadNote("054449b4-93d4-4f97-91cb-e0043fc4497f");
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}

	@Test	//测试笔记信息修改的service层
	public void test3() {
		Note note = new Note();
		note.setCn_note_id("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
		note.setCn_note_title("-----");
		note.setCn_note_body("----");
		System.out.println(service.updateNote(note));
	}
	
	@Test	//测试笔记信息增加的service层
	public void test4() {
		String cn_note_title = "增加笔记3";
		String cn_notebook_id = "e5b75bfb79d14e018d7952317ab74d10";
		String cn_user_id = "39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
		NoteResult<Note> result = service.addNote(cn_note_title, cn_notebook_id, cn_user_id);
		System.out.println(result);
	}
	
	@Test
	public void testDeleteNote() {
		//调用动态参数的时候,可以不创建数组,直接写参数
		service.deleteNotes("ss19055-30e8-4cdc-bfac-97c6bad9518f","mmmm","046b0110-67f9-48c3-bef3-b0b23bda9d4e"); 
	}
	
}









