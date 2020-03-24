package quiz_game;

class CalculatorEx{
	//멤버변수 : 연산의 횟수를 카운트 할 용도로 사용
	int totalOfAdd, totalOfMin, totalOfDiv, totalOfMul;
	
	//멤버변수 초기화 메소드
	public void init( ) {
		totalOfAdd = 0;
		totalOfMin = 0;
		totalOfDiv = 0;
		totalOfMul = 0;
	}
	public double add(int a, int b) {	
		totalOfAdd++; //덧셈 연산횟수 카운트
		return a + b;
	}
	public double min(double a, double b) {
		totalOfMin++;
		return a - b;
	}
	public double div(int a, int b) {
		totalOfDiv++;
		return a / b;
	}
	public double mul(double a, double b) {
		totalOfMul++;
		return a * b;
	}
	//연산횟수를 출려하는 멤버메소드
	public void showOpCount() {
		
		System.out.printf("덧셈횟수 : %d \n", totalOfAdd);
		System.out.printf("뺄셈횟수 : %d \n", totalOfMin);
		System.out.printf("곱셈횟수 : %d \n", totalOfMul);
		System.out.printf("나눗셈횟수 : %d", totalOfDiv);	
	}
}

public class QuSimpleCalculator {

	public static void main(String[] args) {

		CalculatorEx cal = new CalculatorEx();
		cal.init();
		System.out.println("1 + 2 = " + cal.add(1 , 2));
		System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
		System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
		System.out.println("100 / 25 = " + cal.div(100 , 25));
		System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
		cal.showOpCount();
	}
}