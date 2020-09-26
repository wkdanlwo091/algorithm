package algorithm;

import java.util.Scanner;

public class BOJ_1904 {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		dp = new int[1000001];
		dp[1] = 1;
		dp[2] = 2;//00, 11
		
		for(int i =3;i <= N;i++) {
				dp[i] = dp[i-2] + dp[i-1];
				dp[i] %=  15746;
		}
		
		System.out.println(dp[N]);
	}

}
