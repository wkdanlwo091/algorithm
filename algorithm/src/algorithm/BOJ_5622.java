package algorithm;

import java.util.Scanner;

public class BOJ_5622 {

	public static void main(String[] args) {
		String st;
		int ans = 0;
		Scanner scan = new Scanner(System.in);
		st = scan.next();

		for (int i = 0; i < st.length(); i++) {

			if(st.charAt(i) <= 'R')
				ans += (int) (st.charAt(i) - 'A') / 3 + 3;
			else if(st.charAt(i) <= 'S'){
				ans += 8;
			}
			else if(st.charAt(i) <= 'V'){
				ans += 9;
			}
			else if(st.charAt(i) <= 'Z'){
				ans += 10;
			}
		}
		System.out.println(ans);
	}
}
