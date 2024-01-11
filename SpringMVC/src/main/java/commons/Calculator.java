package commons;

public class Calculator {
	
	public int diff(int a, int b) {
		return Math.abs(a-b);
	}
	
	public int noopDiff(int a, int b) {
		return a-b;
	}
	
	public int add(int a, int b) {
		return a+b;
	}
}
