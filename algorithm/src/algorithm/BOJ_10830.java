package algorithm;

import java.util.Scanner;

public class BOJ_10830 {

	static int N;
	static int[][] A;//A값 
	static int[][] result;//
	static int[][] memo;
	static long B;
	
	static int[][] dac(long b) {
		
		if(b == 1) {
			return A;
		}
		
		int [][] first;
		int [][] temp = new int[N+1][N+1];
		int [][] ans = new int[N+1][N+1];
		
		if(b %2 == 0) {
			first = dac(b/2);
			for(int i = 1;i <= N;i++) {
				for(int k = 1;k <= N;k++) {
					int sum = 0;
					for(int j = 1;j <= N;j++) {
						sum += (first[i][j] * first[j][k]) ;
					}
					ans[i][k] = sum% 1000;
				}
			}
			
		}else if(b %2 == 1) {
			first = dac(b/2);
			for(int i = 1;i <= N;i++) {
				for(int k = 1;k <= N;k++) {
					int sum = 0;
					for(int j = 1;j <= N;j++) {
						sum += (first[i][j] * first[j][k]) ;
					}
					temp[i][k] = sum % 1000;
				}
			}
			
			for(int i = 1;i <= N;i++) {
				for(int k = 1;k <= N;k++) {
					int sum = 0;
					for(int j = 1;j <= N;j++) {
						sum += (temp[i][j] * A[j][k]) ;
					}
					ans[i][k] = sum % 1000;
				}
			}

		}
		
		return ans;
	}
	
	public static void main(String[] args) {//예시 test의 답은 맞다. 
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		B = scan.nextLong();
		A = new int[N+1][N+1];
		result = new int[N+1][N+1];
		
		for(int i =1;i<= N;i++) {
			for(int j = 1;j <= N;j++) {
				A[i][j] = scan.nextInt()%1000;
			}
		}
		
		result = dac(B);
			
		for(int i = 1;i <= N;i++) {
			for(int j = 1;j<= N;j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}
}
