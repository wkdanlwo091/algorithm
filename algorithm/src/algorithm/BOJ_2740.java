package algorithm;

import java.util.Scanner;

public class BOJ_2740 {
	static int N, M, K;
	static int [][]A;
	static int [][]B;
	static int [][]result;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		A = new int[N+1][M+1];
		for(int i = 1;i <= N;i++) {
			for(int j = 1;j <= M;j++) {
				A[i][j] = scan.nextInt();
			}
		}
		
		M = scan.nextInt();
		K = scan.nextInt();
		B = new int[M+1][K+1];

		result = new int[N+1][K+1];
		
		for(int i = 1;i <= M;i++) {
			for(int j = 1; j <= K;j++) {
				B[i][j] = scan.nextInt();
			}
		}
		
		
		for(int i = 1; i <= N;i++) {
			for(int k = 1; k <= K; k++) {
				int sum = 0;
				for(int j =1;j <= M;j++) {
					sum += A[i][j] * B[j][k];
				}
				result[i][k] = sum;
			}
		}
		
		
		for(int i = 1;i<= N;i++) {
			for(int j = 1;j<= K;j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
