package algorithm;

import java.util.Scanner;

public class BOJ_2675 {

	
	public static void main(String[] args) {
		int T, R;
		String S;
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int i =0 ;i < T;i++) {
			R = scan.nextInt();//1
			S = scan.next();//B
			for(int j = 0;j< S.length();j++) {
				char curr = S.charAt(j);
				for(int k= 0;k < R;k++) {
					System.out.print(curr);
				}
			}				System.out.println();

		}
	}
}
