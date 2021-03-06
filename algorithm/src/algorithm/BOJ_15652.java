package algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_15652 {

	static int N;
	static int M;
	static int[] arr;
	static int[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

	static void dp(int cnt, int curr) {//cnt는 숫자의 개수 index, curr은 전 스테이트의 값
		
		if(cnt == M) {
			for(int i = 0 ;i < M;i++) {
				try {
					bw.write(arr[i] + " ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		for(int i = 1;i <= N;i++) {//N은 숫자의 범위 
			if(visit[i] != M) {//숫자의 중복 처리
				if(curr <= i) {//우측 숫자가 좌측 숫자보다 같거나 크다.
					visit[i]++;
					arr[cnt] = i;
					dp(cnt+1, i);
					visit[i]--;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N+1];
		visit = new int[N+1];
		dp(0, 0);
		
		try {
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
