package algorithm;

public class Katalk_1 {

	
	
	public int solution(String s) {
		int answer = s.length();
		int tempAnswer = 0;//���� ���ڿ� ����
		
        for(int i = 1 ;i <= s.length()/2 ;i++){//i���� �����ϱ� , �ִ� ������ ���ڿ������� ���̴�. 
            
        	tempAnswer = 0;
        	String temp = s.substring(0, i);
        	int index = 0;
        	
        	for(int j = 0; j < s.length(); j = j+i) {
        		
        		if(j+i > s.length()) {//����� last index�� �Ѿ�� last index���� ¥����. 
        			if(index == 1)
        				tempAnswer = tempAnswer + i;//���� ������ index ���ϰ� 
        			else if(index != 1) {
        				tempAnswer = tempAnswer + Integer.toString(index).length() + i;// 50a�϶�     ���� ���� + �ڸ� ����  2+1
        			}
        			tempAnswer  = tempAnswer + s.length()-j;
        			break;
        		}
        		
        		if( temp.equals(s.substring(j, j+i))) {//����.
        			System.out.println("1 " + j);
        			index++;
        		}
        		else {
        			System.out.println("2 " + j);
        			if(index == 1)
        				tempAnswer = tempAnswer + i;//���� ������ index ���ϰ� 
        			else if(index != 1) {
        				tempAnswer = tempAnswer + Integer.toString(index).length() + i;// 50a�϶�     ���� ���� + �ڸ� ����  2+1
        			}
        			System.out.println("tempAnswer��" + tempAnswer);
        			index = 1;//�ε��� �Ѱ��� ����
        			temp = s.substring(j, j+i);
        		}
        		
        		if(j == s.length()-i) {//������ index 
        			System.out.println("3" + j);
        			if(index == 1) {
        				tempAnswer = tempAnswer +i;
        			}else if(index != 1) {
        				tempAnswer = tempAnswer + Integer.toString(index).length() + i;// 50a�϶�     ���� ���� + �ڸ� ����  2+1
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