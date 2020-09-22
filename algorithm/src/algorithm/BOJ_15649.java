package algorithm;

import java.util.Scanner;
public class BOJ_15649 {
	static int M  ;
	static int N ;
	static int arr[];
	static boolean visit[] ;
	
	static void dp(int cnt) {
		
		//���� ����
		if(cnt == M) {//���� M
			for(int i = 0 ;i < M;i++) {
				System.out.print(arr[i]);
				System.out.print(" ");
			}
			System.out.println();
			return;
		}
		
		//visit �迭
		for(int i= 1 ;i <= N;i++) {
			if(!visit[i]) {//false�̸�
				visit[i] = true;//�湮
				arr[cnt] = i;
				dp(cnt+1);
				visit[i] = false;//�̹湮
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