package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.sun.accessibility.internal.resources.accessibility;

import ecjtu.cloud_note.dao.NoteDao;
import ecjtu.cloud_note.entity.Note;
import test.TestBase;

public class TestNoteDao extends TestBase {
	private NoteDao dao;
	@Before
	public void init() {
		dao = super.getContext().getBean("noteDao",NoteDao.class);
	}
	@Test	//测试笔记的dao层
	public void test1() {
		List<Map> notes = dao.findByBookId("fa8d3d9d-2de5-4cfe-845f-951041bcc461");
		System.out.println(notes);
		for(Map note:notes) {
			System.out.println("test");
			System.out.println(note.get("cn_note_id")+","+note.get("cn_note_title"));
		}
	}
	@Test  //测试按笔记id查找笔记信息
	public void test2() {
		Note list = dao.findByNoteId("01da5d69-89d5-4140-9585-b559a97f9cb0");
		System.out.println(list);
	}
	
	@Test
	public void testUpdate() {
		Note note = new Note();
		note.setCn_note_id("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
		note.setCn_note_title("====");
		note.setCn_note_body("====");
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		int i = dao.updateNote(note);
		System.out.println(i);
	}
	
	@Test
	public void testAdd() {
		Note note = new Note();
		note.setCn_note_id("mmmm");
		note.setCn_note_title("增加笔记2");
		note.setCn_notebook_id("e5b75bfb79d14e018d7952317ab74d10");
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_user_id("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		dao.save(note);
	}
	
	@Test
	public void testUpdateNoteByMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "java");
		map.put("noteId", "003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
		//故意省略了参数body和time
		dao.updateNoteByMap(map);
	}
	
	@Test
	public void testDeleteNotes() {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] ids = {"066af16d-183b-41ff-8a7c-8a8bd6bfccb4","46b0110-67f9-48cbef3-b0b23bda9d4e","054449b4-93d4-4-91cb-e0043fc4497f"};
		map.put("ids", ids);
		map.put("status", 2);
		int n = dao.deleteNotes(map);
		System.out.println(n);
	}
}

		 		 





