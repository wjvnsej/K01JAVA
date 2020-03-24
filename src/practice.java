import java.util.Arrays;

public class practice {

	public int[] divisible(int[] array, int divisor) {
        
        return Arrays.stream(array).filter
        		(factor -> factor % divisor == 0).toArray();
    }
	
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
    	practice div = new practice();
        int[] array = {10, 9, 7, 5};
        System.out.println
        ( Arrays.toString( div.divisible(array, 5) ));
    }
}