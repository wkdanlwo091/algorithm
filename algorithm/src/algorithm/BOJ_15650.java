package algorithm;

import java.util.Scanner;

public class BOJ_15650 {
	
	static int M;
	static int N;
	static int arr[]  ;
	static boolean visit[];
	
	static void dp(int cnt, int curr) {//cnt는 숫자 번째 , curr은 전의 숫자
		
		if(cnt == M) {
			for(int i= 0 ;i < M;i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//visit 배열
		for(int i = 1; i<= N;i++) {//N이란 
			if(!visit[i]) {
				if(curr < i) {
					visit[i] = true;
					arr[cnt] = i;
					dp(cnt+1, arr[cnt]);
					visit[i] = false;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[M+1];
		visit = new boolean[N+1];
		dp(0,0);
	}
}
