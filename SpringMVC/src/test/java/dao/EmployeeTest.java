package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class EmployeeTest {
	
	EmployeeDAO dao = new EmployeeDAO();
	
	@Test
	public void test1() {
		assertEquals(6, (int)dao.getEmpByDept(30));
	}
	
	@Test
	public void test2() {
		assertNull(dao.getEmpByDept(99));
	}
	
	@Test
	public void test3() {
		assertEquals(6, dao.getEmpByDept1(30));
	}
	
	@Test
	public void test4() {
		assertNull(dao.getEmpByDept1(99));
	}
	
	@Test
	public void test5() {
		assertEquals(6, dao.getEmpByDept2(30).size());
	}
	
	@Test
	public void test6() {
		assertNull(dao.getEmpByDept2(99));
	}

}
