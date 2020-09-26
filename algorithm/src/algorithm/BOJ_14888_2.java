package algorithm;

import java.util.Scanner;

public class BOJ_14888_2 {
	static int N;
	static int A[];
	static int max = -1000000000;
	static int min =  1000000000;
	static int plus =0;
	static int minus = 0;
	static int multi = 0;
	static int divide  = 0;

	static void dfs(int cnt, int p , int mi, int mu , int d , int total) {
		if(cnt == N) {
			max =  Math.max(total, max);
			min =  Math.min(total, min);
			return;
		}
		
		if(p < plus) {
			dfs(cnt+1, p+1, mi, mu, d, total+A[cnt]);
		}
		if(mi < minus) {
			dfs(cnt+1, p, mi+1, mu, d, total-A[cnt]);
		}
		if(mu < multi) {
			dfs(cnt+1, p , mi, mu+1, d, total*A[cnt]);
		}
		if(d < divide) {
			dfs(cnt+1, p , mi, mu, d+1, total/A[cnt]);
		}
		return;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		A = new int[N];
		
		for(int i =0 ;i < N;i++) {
			A[i] = scan.nextInt();
		}
		
		plus = scan.nextInt();
		minus = scan.nextInt();
		multi = scan.nextInt();
		divide = scan.nextInt();
		
		dfs(1,0, 0, 0, 0, A[0]);
		System.out.println(max);
		System.out.println(min);
	}
}