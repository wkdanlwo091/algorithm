package algorithm;

import java.util.*;

public class Katalk_2 {

	
	//��ȣ �������� �ٲٱ� 
	public String flip(String p) {
		if(p.equals("")) {
			return "";
		}
		String temp = "";
		
		for(int i = 0  ;i < p.length(); i++) {
			if(p.charAt(i) == '(') {
				temp += ')';
			}else if(p.charAt(i) == ')'){
				temp += '(';
			}else {
			}
		}
		return temp;
		
	}
	// divide and conquer;
	public String divCon(String p) {
		
		
		Stack<Character> stack = new Stack<Character>();
		int left = 0;
		int right = 0;
		int end = 0;
		String answer = "";
		//u�� �������� �ùٸ����� üũ
			
		if(p.equals(""))
			return "";
		
		
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == ')') {
				if(stack.size() != 0 && stack.peek() == '(') {
					stack.pop();
				}
				left++;
			} else if (p.charAt(i) == '(') {
				stack.push('('); 
				right++;
			}
			
			if(left == right) {
				
				end = i+1;
				
				if(stack.size() == 0) {//�ùٸ� ���ڿ�
					if(end-1 == p.length()-1) {
						return p;//��ü�� �ùٸ� ���ڿ�
					}else {//u�� �ùٸ��̸� v���� �ٽ� ����
						answer += p.substring(0, end);
						return answer + divCon(p.substring(end, p.length()));
					}
				}else {//�������� ���ڿ� 
					stack.clear();
					
					break;
				}

			}
		}
		return '(' + divCon(p.substring(end, p.length())) + ')' + flip(p.substring(1, end-1));
	}

	public String solution(String p) {
		String answer = "";
		if (p.equals("")) {
			return p;
		}
		return divCon(p);
	}
	
	public static void main(String[] args) {
		Katalk_2 katalk_2 = new Katalk_2();
		
		System.out.println(katalk_2.solution(")("));
		System.out.println(katalk_2.solution("(()())()"));
		System.out.println(katalk_2.solution("()))((()"));
	}
}