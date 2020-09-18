package algorithm;

import java.util.Scanner;
public class BOJ_15649 {
	static int M  ;
	static int N ;
	static int arr[];
	static boolean visit[] ;
	
	static void dp(int cnt) {
		
		//종료 조건
		if(cnt == M) {//길이 M
			for(int i = 0 ;i < M;i++) {
				System.out.print(arr[i]);
				System.out.print(" ");
			}
			System.out.println();
			return;
		}
		//visit 배열
		for(int i= 1 ;i <= N;i++) {
			if(!visit[i]) {//false이면
				visit[i] = true;//방문
				arr[cnt] = i;
				dp(cnt+1);
				visit[i] = false;//미방문
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		M = scan.nextInt();
		arr  = new int[9];
		visit = new boolean[9];
		dp(0);
	}
}
