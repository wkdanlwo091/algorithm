package algorithm;

import java.util.Scanner;

public class BOJ_1193 {

	public static void main(String[] args) {
		int X;
		Scanner scan = new Scanner(System.in);
		X = scan.nextInt();
		int cnt = 1;
		int num = 1;//���� ��
		
		for(int i=1;i<= X;i++) {
			
			if(i <=num) {
			}else if(i > num){
				num += ++cnt;
			}
			if(i == X) {
				if(cnt % 2 == 0) {
					//���� �Ʒ���
					System.out.println((i-(num-cnt))  + "/" +  (cnt - (i-(num-cnt +1))));
				}else if(cnt %2 == 1) {
					//�Ʒ��� ����
					System.out.println(cnt - (i-(num-cnt +1)) + "/" + (i-(num-cnt)));
				}
				
				break;
			}
			
		}
	}
}