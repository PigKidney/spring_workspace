package commons;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	// 폴더 위치가 달라도 페키지가 같으면 가져다 쓸 수 있다.
	Calculator calculator = new Calculator();
	
	@Before
	public void before() {
		System.out.println("before!");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
		// assertEquals(expect, actual) : 기대하던 값이 나오면 테스트 성공 아니면 실패
		assertEquals(5, calculator.diff(10, 15));
		
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
		assertEquals(5, calculator.noopDiff(10, 15));
		
	}
}
