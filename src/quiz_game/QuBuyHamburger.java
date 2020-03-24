package quiz_game;


/*
문제5) QuBuyHamburger.java
햄버거를 추상화한 클래스와 기본가격, 세트가격을 추상화한 클래스를 정의하여 
햄버거를 주문시 기본가격 혹은 세트가격으로 출력할수 있도록 프로그램을 구현하시오. 
조건은 다음과 같다.
 
햄버거
멤버변수 : 버거명, 가격, 패티, 소스, 야채
인자생성자 
멤버메소드 : 가격반환(getter), 햄버거정보출력

햄버거 기본가격 : 햄버거 + 음료 + 프렌치프라이의 합계
멤버변수 : 햄버거종류(객체), 음료가격(1000원으로 고정), 
		프렌치프라이가격(1500원으로 고정)
인자생성자
멤버메소드 : 기본가격계산, 결제금액출력

세트가격 : 기본가격클래스를 상속받음. 기본가격에서 500원 할인된 금액으로 계산
멤버변수 : 없음
인자생성자
멤버메소드 : 세트가격계산(Overriding), 결제금액출력(Overriding)

실행결과]
치즈버거
가격:2000
식재료:쇠고기패티, 케챱, 피클
결제금액 : 4500
================================
치킨버거
가격:3000
식재료:닭고기패티, 마요네즈, 양상치
세트결제금액 : 5000
================================
 */
class Burger {
	private String name;
	private int price;
	private String pati;
	private String so;
	private String ya;
	
	public Burger(String name, int price, String pati, String so, String ya) {
		super();
		this.name = name;
		this.price = price;
		this.pati = pati;
		this.so = so;
		this.ya = ya;
	}
	public int getPrice() {
		return price;
	}
	
	public void showburger() {
		System.out.println(name);
		System.out.println("가격 : " + price);
		System.out.println("식재료 : " + pati + so + ya);
	}
}
//햄버거의 기본가격 추상화 
class HamburgerPrice {
	Burger burger;
	final int COKE = 1000;
	final int POTATO = 1500;
	
	public HamburgerPrice(Burger burger) {
		this.burger = burger;
	}
	
	public int price() {
		return burger.getPrice() + COKE + POTATO;
	}
	
	public void showPrice() {
		burger.showburger();
		System.out.println("결제금액 : " + price());
		System.out.println("========================");
	}
}
//세트가격을 추상화(기본가격을 상속)
class SetPrice extends HamburgerPrice {	
	public SetPrice(Burger burger) {
		super(burger);
	}
	
	@Override
	public int price() {
		return super.price() - 500;
	}
	@Override
	public void showPrice() {
		burger.showburger();
		System.out.println("결제금액 : " + price());
		System.out.println("========================");
	}
	
}

public class QuBuyHamburger {

	public static void main(String[] args) {
		
		//치즈버거 객체 생성
		Burger burger1 = new Burger("치즈버거", 2000, "쇠고기패티", "케챱", "피클");
		//치킨버거 객체 생성
		Burger burger2 = new Burger("치킨버거", 3000, "닭고기패티", "마요네즈", "양상치");
		
		//치즈버거를 기본가격으로 구매
		HamburgerPrice price1 = new HamburgerPrice(burger1); 
		price1.showPrice();	// 4500원	
		
		//치킨버거를 세트가격으로 구매
		HamburgerPrice price2 = new SetPrice(burger2); 
		price2.showPrice();	// 5000원
	}
}
