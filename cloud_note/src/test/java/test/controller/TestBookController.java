package test.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ecjtu.cloud_note.controller.LoadBooksController;
import ecjtu.cloud_note.entity.Book;
import ecjtu.cloud_note.util.NoteResult;
import test.TestBase;

public class TestBookController extends TestBase {
	private LoadBooksController controller;
	@Before
	public void init() {
		controller = super.getContext().getBean("loadBooksController",LoadBooksController.class);
		
	}
	@Test
	public void test1() {
		NoteResult<List<Book>> result = controller.execute("52f9b276-38ee-447f-a3aa-0d54e7a736e4");
		System.out.println(result);
	}
}








