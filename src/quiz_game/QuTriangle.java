package quiz_game;

class Triangle {
	//멤버변수
	int bottom, height;
	
	//밑변과 높이를 초기화하는 멤버메소드
	public void init(int bot, int hei) {
		bottom = bot;
		height = hei;
	}
	//삼각형의 넓이를 계산해서 반환하는 멤버메소드
	public double getArea() {
		
		return bottom * height * 0.5;
	}
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}

public class QuTriangle {

	public static void main(String[] args) {
		
		Triangle t = new Triangle();
		t.init(10, 17); //밑변10, 높이17로 초기화
		System.out.println("삼각형의 넓이 : " + t.getArea());
		t.setBottom(50);//밑변 50으로 변경
		t.setHeight(14);//높이 14로 변경
		System.out.println("삼각형의 넓이 : " + t.getArea());
	}
}