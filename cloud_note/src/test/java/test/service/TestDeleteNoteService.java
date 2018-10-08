package test.service;

import org.junit.Before;
import org.junit.Test;

import ecjtu.cloud_note.service.DeleteNoteService;
import test.TestBase;

public class TestDeleteNoteService extends TestBase {
	private DeleteNoteService service;
	@Before
	public void init() {
		service = super.getContext().getBean("deleteNoteService",DeleteNoteService.class);
		
	}
	@Test
	public void test1() {
		System.out.println(service.deleteNoteService("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0"));
	}
}






