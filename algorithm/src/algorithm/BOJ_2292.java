package algorithm;

import java.util.Scanner;

public class BOJ_2292 {
	
	public static void main(String[] args) {
		
		int N;
		int num= 1;// 1 + 6 , 1 + 6 + 12 �̷������� �� ���� ���ϱ�
		int cnt =1;//�氳��
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();

		for(int i = 1;i <=N;i++) {
			
			if(i <=num) {
				
			}else if(i > num) {
				num = num + 6 * cnt++;
			}
				
			if(i == N) {
				System.out.println(cnt );
			}
 		}
	}
}