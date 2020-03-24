package quiz_game;

import java.util.Scanner;

/*
게임설명 : 업다운게임을 메소드를 이용해 구현한다.
1. 컴퓨터는 1~100사이의 숫자 하나를 생성한다.
2. 총 시도횟수는 7번을 부여한다.
3. 사용자는 7번의 시도안에 숫자를 맞춰야 한다.
4. 사용자가 숫자를 입력했을때 컴퓨터는 높은지/낮은지 알려준다.
5. 7번안에 맞추면 성공, 맞추지 못하면 실패라고 출력한다.
6. 성공/실패 후 계속 할지를 물어보고 1이면 게임 재시작, 
	0이면 프로그램을 종료한다.
7. 함수를 사용하여 구현한다.
8. 무한루프에 빠지게 된다면 scan.nextLine()을 활용하여 
	버퍼에 남아있는 Enter키를 제거해주도록 하자.
 */
public class QuUpDownGame {
	
	public static void gameStart() {
		System.out.println("[Game]업다운게임(Up Down Game)\n");
		System.out.println("1~100사이의 숫자가 랜덤으로 생성됩니다.\n"
				+ "기회는 총 7번 입니다. 시작!\n");
		
		int comNum = (int)(Math.random() * 100);
		System.out.println("컴퓨터 랜덤 숫자 : " + comNum);
		user(comNum);
	}
	
	public static void user(int comNum) {
		
		for (int i = 1; i <= 7; i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.printf("\n남은 횟수 : %d번", (8-i));
			System.out.printf("\n%d회 : ", i);
			int userNum = scanner.nextInt();
			
			if(userNum < comNum) {
				System.out.println("입력한 값이 더 작습니다.(UP)");
			}
			else if(userNum > comNum) {
				System.out.printf("입력한 값이 더 큽니다.(DOWN)");
			}
			else if(userNum == comNum) {
				System.out.printf("정답입니다!\n");
				break;
			}
			if(i == 7) {
				System.out.println("\n7번 모두 틀렸습니다.");
				break;
			}
		}
		
		System.out.println("\n다시 하시겠습니까?");
		System.out.println("게임 종료 : 0 / 게임 재시작 : 1");
		Scanner scanner = new Scanner(System.in);
		int retry = scanner.nextInt();
		
		if(retry == 1) {
			gameStart();
		}
		else if(retry == 0) {
			return;
		}
	}
	
	public static void main(String[] args) {
		
		gameStart();	
	}
}