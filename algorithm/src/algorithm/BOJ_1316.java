package algorithm;

import java.util.Scanner;

public class BOJ_1316 {

	
	public static void main(String[] args) {
		int N;
		int cnt = 0;
		String st;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for(int i=0 ;i < N;i++) {
			st = scan.next();
			int []arr = new int[26];//���ĺ� ������Դ��� �����ϴ� �迭
			for(int j = 0;j < st.length();j++) {
				if(j == 0) {
					arr[st.charAt(j)-'a']++;//ù�� ° ���� �׻� 1
				}else if(j>0) {
					if(st.charAt(j-1) == st.charAt(j)) {
						//pp �̷� ��� �ƹ��ϵ� ����. 
					}else {
						arr[st.charAt(j)-'a']++;
						if(arr[st.charAt(j)-'a'] >1) {
							cnt--;//a��  aba �̷������� �������� 2�����°�� 
							break;
						}
					}
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
