package algorithm;

import java.util.Scanner;

public class BOJ_14889 {
	static int arr[];//start
	static int arr2[];//link
	static int visit[];
	static int N;
	static int map[][];
	static int min = 9999999;
	
	static void dfs(int cnt, int curr) {
		
		if (cnt == N/2) {

			int k = 0;	
			
			for(int i = 0;i < N;i++)  {
				if(visit[i] == 0)  
					arr2[k++] = i+1;
			}
			
			int start = 0;
			int link = 0;
			
			
			for(int i = 0;i < N/2;i++) {
				int startTemp = arr[i];
				int linkTemp = arr2[i];
				
				for(int j = 0; j < N/2;j++) {
					if(arr[j] != startTemp) {
						start += map[arr[i]-1][arr[j]-1];
					}
					if(arr2[j] != linkTemp) {
						link += map[arr2[i]-1][arr2[j]-1];
					}
				}
				
			}
			min = Math.min(Math.abs(link-start), min);
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visit[i] == 0 && curr < i+1) {
				visit[i] = 1;
				arr[cnt] = i+1;	
				dfs(cnt + 1, arr[cnt]);
				visit[i] = 0;
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		visit = new int[N];
		arr = new int[N];
		arr2 = new int[N];
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		dfs(0,0);
		System.out.println(min);
	}
}
