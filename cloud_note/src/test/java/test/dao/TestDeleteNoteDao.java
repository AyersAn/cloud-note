package test.dao;

import org.junit.Before;
import org.junit.Test;

import ecjtu.cloud_note.dao.DeleteNoteDao;
import test.TestBase;

public class TestDeleteNoteDao extends TestBase {
	private DeleteNoteDao dao;
	@Before
	public void init() {
		dao = super.getContext().getBean("deleteNoteDao",DeleteNoteDao.class);
	}
	
	@Test
	public void test1() {
		dao.delete("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
	}
}








