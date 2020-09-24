package algorithm;

import java.util.Scanner;

public class BOJ_11720 {
	static int N;


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String st;
		N = scan.nextInt();
		st = scan.next();
		int sum = 0;
		for(int i = 0 ;i< N;i++) {
			sum += st.charAt(i)-'0';
			
		}
		System.out.println(sum);
	}
}
