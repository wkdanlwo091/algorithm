package algorithm;

import java.util.Scanner;

public class BOJ_9663_2 {
	static int ans, n;
	static int[] col;

	static boolean isPossible(int row) {
        // 1행부터 row 행까지 같은 열 혹은 대각선에 위치하는 퀸이 있는지 확인한다.
		for(int i=1; i < row; i++) {
            // i 행과 row 행의 열 값이 같으면 퀸을 놓을수 없다. 
            if(col[i] == col[row]) return false;
            // i 행과 row 행의 열값이 대각선에 위치하는 절대값이면 안된다.
            if(Math.abs(i - row) == Math.abs(col[i] - col[row])) return false;
        }
        return true;
	}
	
	static void dfs(int row) {
		if(row == n) {
			ans++;
		}else {
			for(int i = 1;i <=n ;i++) {
				col[row+1] = i;
				if(isPossible(row+1)) {
					dfs(row+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 1;i <= n ;i++) {
			col = new int[15];//최대 col은 15개
			col[1]= i;//인덱스는 row 값은 column
			dfs(1);
		}
		System.out.println(ans);
	}
}
