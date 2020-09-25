package algorithm;

import java.util.Scanner;

public class BOJ_2839 {

	static int memo[];

	static int dp(int N) {
		
		if (N == 0) {
			return 0;
		}
		if(memo[N] != 0)
			return memo[N];
		int a = 9999, b = 9999;
		if (N - 3 >= 0)
			a = dp(N - 3) + 1;
		if (N - 5 >= 0)
			b = dp(N - 5) + 1;

		memo[N] = Math.min(a, b);
		
		return memo[N];
	}

	public static void main(String[] args) {
		int N;
		Scanner scan = new Scanner(System.in);
		// dp , 배달하는 봉지를 최소 개수를 출력한다.
		N = scan.nextInt();
		memo = new int[N + 1];

		int a = dp(N);
		if(a >= 9999)
			System.out.println("-1");
		else 
			System.out.println(a);
	}
}
