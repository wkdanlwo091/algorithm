package algorithm;

import java.util.Scanner;

public class BOJ_2941 {

	
	public static void main(String[] args) {
		String st;
		int cnt = 0;
		Scanner scan = new Scanner(System.in);
		st = scan.next();
		
		for(int i= 0;i < st.length();i++) {
			if(st.charAt(i) == 'c') {
				if(i+1 < st.length()) {
					if(st.charAt(i+1) == '=' || st.charAt(i+1) == '-') {
						cnt++;
						i++;
						continue;
					} 
				}
				cnt++;
			}else if(st.charAt(i) == 'd') {
				if(i+1 < st.length()) {
					if(st.charAt(i+1) == '-') {
						cnt++;
						i++;
						continue;
					}
				}
				if(i+2 < st.length()){
					if(st.charAt(i+1) == 'z' && st.charAt(i+2) == '=') {
						cnt++;
						i += 2;
						continue;
					}
				}
				cnt++;
			}else if(st.charAt(i) == 'l') {
				if(i+1 < st.length()) {
					if(st.charAt(i+1) == 'j') {
						cnt++;
						i++;
						continue;
					}
				}
				cnt++;
			}else if(st.charAt(i) == 'n') {
				if(i+1 < st.length()) {
					if(st.charAt(i+1) == 'j') {
						cnt++;
						i++;
						continue;
					}
				}
				cnt++;
			}else if(st.charAt(i) == 's') {
				if(i+1 < st.length()) {
					if(st.charAt(i+1) == '=') {
						cnt++;
						i++;
						continue;
					}
				}
				cnt++;
			}else if(st.charAt(i) == 'z') {
				if(i+1 < st.length()) {
					if(st.charAt(i+1) == '=') {
						cnt++;
						i++;
						continue;
					}
				}
				cnt++;
			}else 
				cnt++;
		}
		System.out.println(cnt);
	}
}