package algorithm;

public class Line2020_3 {

	static int memo[][];
	public int[] dp(String i , String j) {
		
		int [ ] temp = new int[2];
		
		
		if(i.length() == 1) {
			if(j.length() == 1) {
				if(Integer.parseInt(i) + Integer.parseInt(j) <10 ) {
					temp[0] = 1;
					temp[1] = Integer.parseInt(i) + Integer.parseInt(j);
					return temp;
				}
				else {
					String string = Integer.toString(Integer.parseInt(i) + Integer.parseInt(j));
					return dp(string.substring(0,1), string.substring(1, 2));
				}
			}
		}
		
		if(memo[Integer.parseInt(i)][0] != 0) {
			if(memo[Integer.parseInt(j)][0] == 0) {
				
			}
		}
		if(memo[Integer.parseInt(j)][0] != 0) {
			if(memo[Integer.parseInt(i)][0] == 0) {
				
			}
		}
		
		if(memo[Integer.parseInt(i)][0] != 0) {
			if(memo[Integer.parseInt(j)][0] != 0) {

				if(memo[Integer.parseInt(j)][1]  + memo[Integer.parseInt(i)][1] > 9) {
					memo[Integer.parseInt(i) + Integer.parseInt(j)][0] = 10;
				}
				
			}
		}

		return dp(Integer.parseInt(i) + Integer.parseInt(j));
	}
	
    public int[] solution(int n) {
        int[] answer = {};
        
        memo = new int[1000000000][2];
        
        if(n == 0) {
        	answer = new int[2];
        	answer[0] = 0;
        	answer[1] = 0;
        	return answer;
        }
        String num = Integer.toString(n);
        
        for(int i = 1;i < num.length();i++) {
        	dp(num.substring(0, i), num.substring(i, num.length()));
        }
        
        
        return answer;
    }

	public static void main(String[] args) {
		
		Line2020_3 line2020_3 = new Line2020_3();
		line2020_3.solution(73425);
		
		}

}
