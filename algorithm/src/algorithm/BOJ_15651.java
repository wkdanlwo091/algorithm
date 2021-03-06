package algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_15651 {
	static int N;
	static int M;
	static int arr[];
	static int visit[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//����

	static void dp(int cnt) throws IOException {
		if(cnt == M) {
			for(int i = 0 ;i < M;i++) {
				bw.write(arr[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = 1;i <= N;i++) {
			if(visit[i] != M) {
				visit[i]++;
				arr[cnt] = i;
				dp(cnt+1);
				visit[i]--;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();

		arr= new int[M+1];
		visit = new int[N+1];
		dp(0);
		bw.flush(); 
		bw.close(); 


	}
	
}
