import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
							{2, 5, 3}, 
							{4, 4, 1}, 
							{1, 7, 3}
							};
		int[] answer = new int [commands.length];
		int x = 0, z = 1;
		
		for(int i = 0; i < answer.length; i++) {
			int[] array2 = new int[ (commands[x][1] - commands[x][0]) + 1];
			
			for (int j = 0; j < array2.length; j++) {
				
				array2[j] =  array[commands[x][0] - z];		
				z--;
				if(array[j] == array[commands[x][1] - 1]) {
					break;
				}
			}
						
			Arrays.sort(array2);
					
			answer[i] = array2[commands[x][2] -1];
			x++;
			z = 1;
		}
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		
	}
	
}
