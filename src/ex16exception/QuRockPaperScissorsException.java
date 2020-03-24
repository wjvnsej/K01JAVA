package ex16exception;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/*
문제1) QuRockPaperScissorsException.java
가위바위보 게임에 다음 조건에 맞는 예외처리 구문을 추가하시오
숫자대신 문자를 입력할 경우 발생되는 예외를 처리하시오. 
(가위바위보 입력시, 재시작여부 입력시)
게임과 관련없는 숫자를 입력했을때 사용자정의 예외클래스를 통해 처리하시오.
예외처리 클래스명 : WrongNumberException
 */

class WrongNumberException extends Exception {
	public WrongNumberException() {
		super("[예외발생] 1~3사이의 숫자를 입력하세요");
	}
}

public class QuRockPaperScissorsException {

	public static void rpsGameStart() throws WrongNumberException {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int gameCount = 0;//게임의 횟수를 카운트하기 위한 변수
				
		while(true) {
		
			//1.난수생성 - 컴퓨터입장의 가위/바위/보
			int com = random.nextInt(10000) % 3 + 1;//1~3사이의난수생성
			System.out.println("컴퓨터:"+ com);
			
			//2.사용자 입력
			int user=0;
			
			try {			 
				System.out.println("가위바위보를 입력하세요");
				System.out.print("가위(1),바위(2),보(3)=>");
				user = scanner.nextInt();
			}
			catch (InputMismatchException e) {
				e.printStackTrace();
			}
			
			//사용자 입력이 1~3이 아니면 사용자정의 예외 발생
			if(!(user == 1 || user ==2 || user == 3)) {
				WrongNumberException wne = new WrongNumberException();
				throw wne;
			}
			
			//3.승부판단 및 결과출력
			if( !(user<1 || user>3) ) {
				//정확하게 입력했을때 승부를 판단
				System.out.printf("사용자:%s, 컴퓨터:%s ",
						displayRPS(user), displayRPS(com));
				
				//승부판단로직
				switch(user - com) {
				case 0:
					System.out.println("비겼습니다");break;
				case 1: case -2:
					System.out.println("이겼습니다");break;
				case -1: case 2:
					System.out.println("졌습니다");break;
				}
								
				//게임카운트 증가
				gameCount++;
			}
			else {
				System.out.println("가위바위보 할줄 모름??븅신~");
			}
					
			//6.5번의 게임이 되었는지 판단후 재시작/종료 확인
			if(gameCount>=5) {
				
				int restart = -1;
				while(true) {
					
					try {
						System.out.print("게임재시작(1), 종료(0):");
						restart = scanner.nextInt();
						if(restart==0 || restart==1) {
							//정상입력이면 루프탈출
							break;
						}
						else {
							System.out.println("잘못입력해씸ㅜㅜ\n");
						}
					}
					catch (InputMismatchException e) {
						e.printStackTrace();
					}
					
				}								
				if(restart==0) {
					//게임종료를 위해 while루프 탈출
					break;
				}
				else {
					System.out.println("게임 재시작^^");
					gameCount=0;
				}
			}
		}	
	}	
	//가위 바위 보를 출력하는 메소드
	public static String displayRPS(int n) {
		String str = "";
		switch (n) {
		case 1:
			str = "가위";break;
		case 2:
			str = "바위";break;
		case 3:
			str = "보";break;
		}
		return str;
	}
	public static void main(String[] args) {
		//가위바위보 게임 메소드 호출
		try {
			rpsGameStart();
		} catch (WrongNumberException e) {
			//개발자가 정의한 예외클래스의 에러메세지 출력
			System.out.println(e.getMessage());
		}
		
	}
}





