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
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//����

	static void dp(int cnt, int curr) {//cnt�� ������ ���� index, curr�� �� ������Ʈ�� ��
		
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
		
		for(int i = 1;i <= N;i++) {//N�� ������ ���� 
			if(visit[i] != M) {//������ �ߺ� ó��
				if(curr <= i) {//���� ���ڰ� ���� ���ں��� ���ų� ũ��.
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