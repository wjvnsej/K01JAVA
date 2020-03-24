package quiz_game;

class ChildProperty{

	/*
	디폴트 생성자는 개발자가 생성자를 정의하지 않았을때만 자동으로 생성된다.
	 */
	//public ChildProperty() {}
	
	//멤버변수 : 어린이가 보유한 구슬의 갯수
	int beadCnt;
	
	//생성자메소드 : 멤버변수를 초기화 한다.
	public ChildProperty(int bead) {
		beadCnt = bead;
	}
	
	public void showProperty() {
		System.out.printf("보유 구슬의 개수 %d \n", beadCnt);
	}
	
	public void obtainBead(ChildProperty child, int bCnt) {
		//게임에 슬리한 어린이는 해당 메소드를 호출하는 주체, 즉 해달 객체가 된다.
		this.beadCnt += bCnt;
		//매개변수로 전달된 어린이 객체는 게임에 패배하여 구슬 bCnt만큼 차감해야함
		child.beadCnt -= bCnt;
	}
}

public class QuMarbles {

	public static void main(String[] args) {

		ChildProperty child1 = new ChildProperty(20);
		ChildProperty child2 = new ChildProperty(15);

		System.out.println("게임 전 구슬의 보유 개수");
		System.out.print("어린이1 : ");
		child1.showProperty(); 
		System.out.print("어린이2 : ");
		child2.showProperty(); 
		/*1차게임 : 어린이1은 어린이2의 구슬 5개 획득*/
		child1.obtainBead(child2, 5);//25,16
		/*2차게임 : 어린이2가 어린이1의 구슬 9개 획득*/
		child2.obtainBead(child1, 9);//10,19
		System.out.println("\n게임 후 구슬의 보유 개수");
		System.out.print("어린이1 : ");
		child1.showProperty(); 
		System.out.print("어린이2 : ");
		child2.showProperty();
	}
}