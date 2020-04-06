package quiz_game;

import java.util.Scanner;

public class Sort_Selection {

	public static void main(String[] args) {
		
		int rand;
		int temp;
		int index;
		int x=0;
		int[] arr = new int[10];
		while(x<10){
			int check = 0;
			rand = (int) (Math.random()*100) + 1;
			for (int i = 0; i < x; i++) {
				if (arr[i] == rand) {
					check = 1;
					break;
				}
			}
			if (check == 1) {
				continue;
			}
			arr[x] = rand;
			x++;
		}

		System.out.print("배열 보기 : ");
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("정렬 방식을 선택하세요.");
		System.out.println("1. 오름차순");
		System.out.println("2. 내림차순");
		System.out.print("입력 : ");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			for (int i = 0; i < 10; i++) {
				index = i;
				for (int j = i + 1; j < 10; j++) {
					if (arr[index] > arr[j]) {
						index = j;
					}
				}
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				System.out.print("Sort" + (i + 1) + "번 진행 : ");
				for (int k = 0; k < 10; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
		else if (choice == 2) {
			for (int i = 0; i < 10; i++) {
				index = i;
				for (int j = i + 1; j < 10; j++) {
					if (arr[index] < arr[j]) {
						index = j;
					}
				}
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				System.out.print("Sort" + (i + 1) + "번 진행 : ");
				for (int k = 0; k < 10; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("똑바로 선택하세요.");
		}

	}

}
