package ex10accessmodifier;

//과일판매자를 추상화한 클래스
class FruitSeller{
   
   //외부클래스에서 접근할 수 없도록 private으로 선언한다.
   private int numOfApple; //판매자의 사과 보유갯수
   private int myMoney;//판매수익
   private final int APPLE_PRICE;//다시 상수로 선언함.
   /*
    상수는 값의 변경이 불간으하고 단 한번만 초기화되기
    대문에 일반적인 멤버메소드에서는 초기화 할수 없다..
    단, 생성메소드에서는 초기화가 가능하다.
    마음대로 호출할수 없고, 객체생성시 단 한번만 호출되는
    특성이 동일하기 대문에 한번이상 초기화 되지 않음이 보장되기 때문이다.
    */
   
   public FruitSeller(int money, int appleNum, int price) {
      myMoney = money;
      numOfApple = appleNum;
      APPLE_PRICE = price;//<= 생성자 내에서는 상수를 초기화할수있음.
   }
   
   public int saleApple(int money) {
      int num = money / APPLE_PRICE;
      numOfApple -= num;
      myMoney += money;
      return num;
   }
   
   public void showSaleResult() {
      System.out.println("[판매자]남은 사과갯수 : " + numOfApple);
      System.out.println("[판매자]판매수익 : " + myMoney);      
   }
}

//구매자를 표현한 클래스
class FruitBuyer{
   
   private int myMoney;//보유한 금액
   private int numOfApple;//구매한 사과의 갯수
   
   public FruitBuyer(int _myMoney, int _numOfApple) {
      myMoney = _myMoney;
      numOfApple = _numOfApple;
   }
   
   
   public void buyApple(FruitSeller seller, int money) {
      numOfApple += seller.saleApple(money);
      myMoney -= money;
   }
   
   public void showBuyResult() {
      System.out.println("[구매자]현재 잔액 : " + myMoney);
      System.out.println("[구매자]사과 갯수 : " + numOfApple);   
   }
}

public class E03InformationHiding {

   public static void main(String[] args) {
   
      /*
       생성자를 통해서 객체 생성과 동시에 초기화되므로
       init(초기화메소드)메소드를 호출할 필요가 없어진다.
       따라서 객체생성 코드를 한줄로 줄일수 있다.
       */
      //판매자1
      FruitSeller seller1 = new FruitSeller(0, 100, 1000);
      
      //판매자2
      FruitSeller seller2 = new FruitSeller(0, 80, 500);
      
      FruitBuyer buyer = new FruitBuyer(10000, 0);
      
      System.out.println("구매행위가 일어나기전의 상태");
      seller1.showSaleResult();
      seller2.showSaleResult();
      buyer.showBuyResult();
      
      /*
       멤버변수를 private으로 선언하면 외부클래스에서는 접근이 불가능하므로
       아래 코드는 에러가 발생된다.
       */
//      seller1.myMoney +=1000; //판매자에게 1000원을 지부라고
//      seller1.numOfApple -= 50;//사과 50개를 구매하였다.
//      buyer.numOfApple +=50;
//         
//      seller2.myMoney += 1000;//판매자2에게 1000원을 지불하고
//      seller2.numOfApple -=70;//사과 70개를 구매하였다.
//      buyer.numOfApple +=70;//하지만 구매자의 보유금액은 차감되지 않았다.
      
      /*
       판매자 1,2에게 각가의 금액을 지불하고 금액에 해당하는 
       사과를 정상적으로 구매하였다.
       정보은닉을 통해 판매의 규칙이 지켜지게 되었다.
       */
      buyer.buyApple(seller1, 1000);
      buyer.buyApple(seller2, 1000);
      
      System.out.println("구매행위가 일어난 후의 상태");
      seller1.showSaleResult();
      seller2.showSaleResult();
      buyer.showBuyResult();
      
   }
}