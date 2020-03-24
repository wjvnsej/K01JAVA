package quiz_game;

public class Qu_04_06 {

	public static void main(String[] args) {

		/*
		 ※ex04controlstatement 패키지에서 작성하세요.
문제1] 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
파일명 : Qu_04_06.java
출력]
	*
	* *
	* * *
	* * * *
	* * * * *

		 */
		
		int i=1;
		while(i<=9) {
			int j=1;
			while(j<=9) {
				if(i>=j) {
					//j는 i의 갯수만큼만 출력한다.
					System.out.print("2 X ");
				}
				j++;
			}
			System.out.println();//*5개 찍고 줄바꿈
			i++;
		}
	}

}
