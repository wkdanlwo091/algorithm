package algorithm;

import java.util.Scanner;

public class BOJ_9663 {

	static int N;
	static int arr[][];
	static int answer;
	
	static boolean check(int y, int x) {
		//left
		for(int i = 1;i <  x;i++) {
			if(arr[y][i] == 1) {
				return false;
			}
		}
		//up
		for(int i = 1;i <  y;i++) {
			if(arr[i][x] == 1) {
				return false;
			}
		}
		//left diag
		int i = 1;
		while(true) {
			if(y-i == 0 || x-i == 0) {
				break;
			}
			if(arr[y-i][x-i] == 1) {
				return false;
			}
			i++;
		}
		//right diagonal
		i = 1;
		while(true) {
			if(y-i == 0 || x+i == N+1) {//y는 내려가고
				break;
			}
			if(arr[y-i][x+i] == 1) {
				return false;
			}
			i++;
		}
		
		return true;
	}
	
	static void dfs(int y, int x, int cnt) {// 다음 스테이트
		
		if(cnt == N) {
			answer++;
			return;
		} 
		
		for(int i = y; i <= N;i++) {
			for(int j = x; j<= N;j++) {
				
				if(i == N && j == N)
					return;
				
				if(j == N) {
					if(check(i+1, 1)) {
						arr[i+1][1] = 1;
						dfs(i+1,1, cnt+1);
						arr[i+1][1] = 0;
					}
					arr[i+1][1] = 0;
				}else if(j < N) {
					if(check(i, j+1)) {
						arr[i][j+1] = 1;
						dfs(i, j+1, cnt+1);
						arr[i][j+1] = 0;
					}
					arr[i][j+1] = 0;
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N+1][N+1];
		
		arr[1][1] = 1;
		dfs(1,1, 1);
		arr[1][1] = 0;
		dfs(1,1, 0);
		
		System.out.println(answer);
	}
}