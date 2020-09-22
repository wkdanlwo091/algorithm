package algorithm;

import java.util.Scanner;

public class BOJ_9663_2 {
	static int ans, n;
	static int[] col;

	static boolean isPossible(int row) {
        // 1����� row ����� ���� �� Ȥ�� �밢���� ��ġ�ϴ� ���� �ִ��� Ȯ���Ѵ�.
		for(int i=1; i < row; i++) {
            // i ��� row ���� �� ���� ������ ���� ������ ����. 
            if(col[i] == col[row]) return false;
            // i ��� row ���� ������ �밢���� ��ġ�ϴ� ���밪�̸� �ȵȴ�.
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
			col = new int[15];//�ִ� col�� 15��
			col[1]= i;//�ε����� row ���� column
			dfs(1);
		}
		System.out.println(ans);
	}
}