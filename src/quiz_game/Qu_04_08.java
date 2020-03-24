package quiz_game;
/*
문제3] 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
파일명 : Qu_04_08.java
출력]	
		* * * * *
		* * * *
		* * *
		* *
		*	

*/
public class Qu_04_08 {

	public static void main(String[] args) {
		
		// *를 출력할 층 수를 표현하는 상수
		final int FLOOR = 7;
		
		/*
		 FLOOR-x+1
		 	-> 변수x가 증가함에 따라 점점 감소하는 y값을 표현하기 위한 일반식 정의
		 */
		for(int x=1;x<=FLOOR;x++) {
			for(int y=1;y<=(FLOOR-x+1);y++) {//floor-x+1=y
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
