package quiz_game;

public class Qu_04_07 {

	public static void main(String[] args) {

		int sum=0;
		//반복의 횟수가 명확 -> for문이 좋음.
		//1~100까지 반복
		for(int i=1;i<=100;i++) {
			//3의 배수 이거나 7의 배수
		
			if(i%3==0 || i%7==0){
				//3과 7의 공배수가 아닌 정수
				if(i%(3*7)!=0) {
					sum += i;
					System.out.println("i="+i);
			}
		}
	}
	System.out.println("결과="+sum);

	}
}
