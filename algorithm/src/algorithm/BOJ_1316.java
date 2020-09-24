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
			int []arr = new int[26];//알파벳 몇번나왔는지 저장하는 배열
			for(int j = 0;j < st.length();j++) {
				if(j == 0) {
					arr[st.charAt(j)-'a']++;//첫번 째 수는 항상 1
				}else if(j>0) {
					if(st.charAt(j-1) == st.charAt(j)) {
						//pp 이런 경우 아무일도 없다. 
					}else {
						arr[st.charAt(j)-'a']++;
						if(arr[st.charAt(j)-'a'] >1) {
							cnt--;//a가  aba 이런식으로 떨어져서 2번나온경우 
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
