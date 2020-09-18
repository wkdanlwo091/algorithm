package algorithm;

public class Katalk_4 {
	
	
	public int check(String[] words, String query, int start, int end) {
		
		int num = 0; 
		
		for(int i= 0 ;i < words.length;i++) {
			
			if(start != 0) {
				
				
				if(words[i].length() == query.length()) {
				

					if(words[i].substring(0, start).equals(query.substring(0, start ))) {
							num++;
					}
					
				
				}

								
			}else if(start == 0){
				
				if(words[i].length() == query.length()) {

					if(words[i].substring(end+1, words[i].length()).equals(query.substring(end+1, words[i].length()))) {
							num++;
					}

					
				}

			}
			
		}
		
		System.out.println(num + " " + words[0] + " " + query + " " + start + " " + end);
		
		return num;
	}
	
    public int[] solution(String[] words, String[] queries) {
    	
        int[] answer = new int[queries.length];
        int start = 0 , end = 0;
        
        for(int i = 0 ;i< queries.length;i++) {
        	start = -1;
        	end = -1;
        	for(int j = 0 ;j < queries[i].length();j++) {
        		if(queries[i].charAt(j) == '?') {
        			
        			if(start == -1) {
        				start = j;
        			}
        			if(j == queries[i].length()-1) {
        				end = j;
        			}
        			if(j +1 < queries[i].length() && queries[i].charAt(j+1) != '?') {
        				end = j;
        			}
        			
        			
        		}
        	}
        	
        	//??의 start end index 구하고 함수 호출 
        	answer[i] = check(words, queries[i], start, end);
        	
        	
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		
		Katalk_4 katalk_4 = new Katalk_4();
		String words[] = new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String queries[] = new String[] {"fro??", "????o", "fr???", "fro???", "pro?"};
		System.out.println(katalk_4.solution(words, queries));
		
	}
}
	