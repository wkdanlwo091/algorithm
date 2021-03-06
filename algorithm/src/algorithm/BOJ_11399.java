package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399 {

	public static void main(String[] args) {
		int N;
		int P[];
		int answer = 0;

		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		P = new int[N];
		

		for(int i = 0;i < P.length;i++) {
			P[i] = scan.nextInt();
		}
		Arrays.sort(P);

		
		for(int i = 0 ;i<  P.length;i++) {
			int tmp = 0;
			for(int j = 0;j< i;j++) {
				tmp += P[j];
			}
			answer = answer + tmp + P[i];
		}
		System.out.println(answer);
	}

}
