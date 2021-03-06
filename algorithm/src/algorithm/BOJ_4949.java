package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_4949 {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Character> stc = new Stack<>();
		String st ;
		
		while(true) {
			
			stc.clear();
			st = scan.nextLine();
			if(st.equals(".")) {
				break;
			}
			
			for(int i = 0 ;i < st.length();i++) {
				if(st.charAt(i) == '[') {
					stc.push(st.charAt(i));
				}else if(st.charAt(i) == '(') {
					stc.push(st.charAt(i));
				}else if(st.charAt(i) == ']') {
					if(!stc.empty()) {
						if(stc.peek() == '[') {
							stc.pop();
						}else if(stc.peek() == '(') {
							//no
							System.out.println("no");break;
						}
					}else if(stc.empty()) {
						System.out.println("no");break;
					}
				}else if(st.charAt(i) == ')') {
					if(!stc.empty()) {
						if(stc.peek() == '(') {
							stc.pop();
						}
						else if(stc.peek() == '[') {
							//no
							System.out.println("no");break;
						}
					}else if(stc.empty()) {
						System.out.println("no");break;
					}
				}
				
				if(i == st.length()-1) {
					if(stc.empty())
						System.out.println("yes");
					else if(!stc.empty())
						System.out.println("no");
				}
			}

		}
		
	}
}
