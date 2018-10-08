package test.dao;

import org.junit.Before;
import org.junit.Test;

import ecjtu.cloud_note.dao.EmpDao;
import ecjtu.cloud_note.entity.Emp;
import test.TestBase;

public class TestEmpDao extends TestBase {
	private EmpDao dao;
	@Before
	public void init() {
		dao = super.getContext().getBean("empDao",EmpDao.class);
		
	}
	@Test
	public void test() {
		Emp emp = new Emp();
		emp.setName("小三");
		emp.setAge(34);
		dao.save(emp);
		int id = emp.getId();
		System.out.println("刚插入的ID:"+id);
		System.out.println(emp);
	}
}




