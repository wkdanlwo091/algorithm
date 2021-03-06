package algorithm;

public class Katalk_1 {

	
	
	public int solution(String s) {
		int answer = s.length();
		int tempAnswer = 0;//원본 문자열 길이
		
        for(int i = 1 ;i <= s.length()/2 ;i++){//i개로 압축하기 , 최대 압축은 문자열길이의 반이다. 
            
        	tempAnswer = 0;
        	String temp = s.substring(0, i);
        	int index = 0;
        	
        	for(int j = 0; j < s.length(); j = j+i) {
        		
        		if(j+i > s.length()) {//덩어리가 last index를 넘어갈때 last index까지 짜른다. 
        			if(index == 1)
        				tempAnswer = tempAnswer + i;//전에 증가한 index 더하고 
        			else if(index != 1) {
        				tempAnswer = tempAnswer + Integer.toString(index).length() + i;// 50a일때     숫자 길이 + 자른 숫자  2+1
        			}
        			tempAnswer  = tempAnswer + s.length()-j;
        			break;
        		}
        		
        		if( temp.equals(s.substring(j, j+i))) {//같다.
        			//System.out.println("1 " + j);
        			index++;
        		}
        		else {
        			//System.out.println("2 " + j);
        			if(index == 1)
        				tempAnswer = tempAnswer + i;//전에 증가한 index 더하고 
        			else if(index != 1) {
        				tempAnswer = tempAnswer + Integer.toString(index).length() + i;// 50a일때     숫자 길이 + 자른 숫자  2+1
        			}
        			//System.out.println("tempAnswer는" + tempAnswer);
        			index = 1;//인덱스 한개로 복귀
        			temp = s.substring(j, j+i);
        		}
        		
        		if(j == s.length()-i) {//마지막 index 
        			//System.out.println("3" + j);
        			if(index == 1) {
        				tempAnswer = tempAnswer +i;
        			}else if(index != 1) {
        				tempAnswer = tempAnswer + Integer.toString(index).length() + i;// 50a일때     숫자 길이 + 자른 숫자  2+1
        			}
        		}
        		
        	}
        	if(tempAnswer < answer ) {
        		answer = tempAnswer;
        	}
        	
        	
        }
	    return answer;
	}

	public static void main(String[] args) {
		Katalk_1 a  =new Katalk_1();
		System.out.println(a.solution("xababcdcdababcdcd"));
	}
}
