package test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test test = new Test();
		
		test.test(100);
	}

	public void test(int i){
		System.out.println(i);
		if(i != 0)
			test(i-1);
	}
}
