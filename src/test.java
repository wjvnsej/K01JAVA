
public class test {

	public static void main(String[] args) {
		
		String[] participant = new String[3];
		participant[0] = "leo";
		participant[1] = "kiki";
		participant[2] = "eden";
		
		String[] completion = new String[2];
		participant[0] = "leo";
		participant[1] = "kiki";
		
		
	}
	
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        for (int i = 0; i <= participant.length; i++) {
            
            for(int j = 0; j <= completion.length; j++) {
                
                if(participant[i] != completion[j]) {
                    answer = participant[i];
                    completion[j] = "";
                    break;
                }
            }
        }
        
        return answer;
    }

}
