package quiz_game;
import java.util.Scanner;

/*
파일명 : QuBaseballGame.java

게임설명 : 야구게임을 메소드를 이용하여 구현한다.
1. 중복되지 않는 3개의 정수를 생성한다.(1~9)
2. 사용자는 3개의 숫자를 입력한다.
3. 생성된 3개의 숫자를 맞추는데 위치까지 정확히 맞춰야 한다.
4. 숫자와 숫자의 위치까지 일치하면 strike 로 판정한다.
5. 숫자는 맞지만 위치가 틀렸다면 ball 로 판정한다.
6. 숫자3개가 모두 일치하지 않으면  out 으로 판정한다.
7. 3 strike 가 되면 게임은 종 료된다.
8. 시도한 횟수를 표시한다.
9. 계속할지 종료할지 여부를 물어보고 다음 진행을 한다.

위 문제의 변수들을 배열을 이용하여 구현해본다.
   int com1, com2, com3; -> int[] com = new int[3];
   int user1, user2, user3; -> int[] user = new int[3]; 
3개의 난수를 생성하는 부분과 스트라이크, 
볼을 판정하는 부분은 배열을 이용한 로직으로 변경해야 한다.
 */
public class QuBaseballGame {
	//정적 변수 초기화
	public static int[] comNum = new int[3];
	public static int[] userNum = new int[3];
	public static int strCnt = 0;
	public static int ballCnt = 0;
	public static int tryCnt = 0;
	
	public static void gameStart() {
		comRndNumber();
	}
	
	//1~9까지 중복없는 랜덤정수 3개 생성 메소드(컴퓨터)
	public static void comRndNumber() {
		System.out.println("[Game]야구게임(Baseball Game)\n");
		
		//comNum 배열에 랜덤정수 3개 입력
		for(int i = 0; i < comNum.length; i++) {
			comNum[i] = ((int)(Math.random()*100)%9)+1;
			
			//중복 값이 있을 시 배열에 재 입력
			for (int j = 0; j < i; j++) {				
				
				if(comNum[i] == comNum[j]) {
					i--;
				}
				
			}////end of for(중복검사)
		}////end of for(랜덤생성)
		
		// comNum배열 출력
		System.out.println("컴퓨터가 생성한 정수 3개(1~9)");
		for(int i = 0; i < comNum.length; i++) {
			System.out.printf("%d ",comNum[i]);
		}
		System.out.println("");
		
		userNumber();
	}
	
	public static void userNumber() {
		System.out.println("정수 3개를 입력하세요.(1~9)");
		
		//사용자가 입력한 3개의 정수를 userNum배열에 입력한다.
		for (int i = 0; i < userNum.length; i++) {
			Scanner scanner = new Scanner(System.in);
			userNum[i] = scanner.nextInt();
		}
		
		// userNum배열 출력
		System.out.println("사용자가 입력한 정수 3개(1~9)");
		for(int i = 0; i < userNum.length; i++) {
			System.out.printf("%d ",userNum[i]);
		}
		System.out.println("");
		
		arrCompare();
	}
	
	//comNum배열과 userNum배열을 서로 비교하여 스트라이크, 볼, 아웃을 판정한다.
	public static void arrCompare() {
		
		while (true) {
			for (int i = 0; i < comNum.length; i++) {
				for (int j = 0; j < userNum.length; j++) {
					
					if(i == j && comNum[i] == userNum[j]) {
						strCnt++;//스트라이크 카운트 +1
					}
					
					if(i != j && comNum[i] == userNum[j]) {
						ballCnt++;//볼 카운트 +1
					}
				}
			}
			tryCnt++;//시도횟수 카운트 +1
			
			/*
			1회 시도마다 result메소드로 스트라이크와 볼 카운트 값을 넘겨
			각각의 갯수를 출력해준다.
			 */
			result(strCnt, ballCnt);
			
			/*
			다음 횟수 시작을 위해 스트라이크와 볼 카운트 횟수를 초기화 하고
			사용자가 userNum에 새로운 값을 넣을 수 있도록 userNumber메소드를
			호출한다.
			 */
			strCnt = ballCnt = 0;
			userNumber();
		}
	}
	
	// 매번 횟수마다의 결과를 출력해주는 메소드
	public static void result(int strCnt, int ballCnt) {
		
		//3스트라이크가 아니므로 스트라이크와 볼 카운팅 출력만 해준 후 return
		if(strCnt > 0) {
			System.out.printf("\n%d strike!  ", strCnt);
		}
		if(ballCnt > 0) {
			System.out.printf("%d ball!\n", ballCnt);
			return;
		}
		
		//아웃이나 3스트라이크로 성공시 게임 재 시작 메소드 호출
		if(strCnt == 0 && ballCnt == 0) {
			System.out.println("out!"); 
			reStart();
		}
		if(strCnt == 3) {
			System.out.printf(" %d번만에 성공!", tryCnt);
			reStart();
		}
	}
	
	//재시작 여부 확인 메소드
	public static void reStart() {
		System.out.println("\n\n다시 하시겠습니까?");
		System.out.println("게임 종료 : 0 / 게임 재시작 : 1");
		Scanner scanner = new Scanner(System.in);
		int retry = scanner.nextInt();
		
		//정적 변수값 모두 초기화 후 프로그램 재 시작
		if(retry == 1) {
			strCnt = ballCnt = tryCnt = 0;
			gameStart();
		}
		//프로그램 종료
		else if(retry == 0) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		
		gameStart();
		
	}
}