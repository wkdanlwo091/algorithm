package algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1181 {

	public static void main(String[] args) {
		int N;
		int  smallest;
		String string[], tmp;
		HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		string = new String[N];
		
		for(int i= 0 ;i< N;i++) {
			tmp = scan.next();
			if(hashMap.get(tmp) == null) {
				hashMap.put(tmp, true);
				string[i] = tmp;
			}else {
				i--;
				N--;// 중복되는 문자열 제거 하였으므로 전체 N 수 줄어야한다. 
			}
		}
		//문자열 length() 비교 
		for(int i = 0 ;i < N-1;i++) {
			smallest = i;
			for(int j = i+1; j < N;j++) {
				if(string[j].length() < string[smallest].length()) {
					smallest = j;
				}
			}
			if(i != smallest) {//i가 자기 자신이 아닐 때 swap
				tmp = string[i];
				string[i] = string[smallest];
				string[smallest] = tmp;
			}
		}
		
		//문자열 사전적 순서 비교
		for(int i = 0 ;i < N-1;i++) {
			smallest = i;
			for(int j = i+1; j < N;j++) {
				if(string[smallest].length() == string[j].length()) {
					if(string[smallest].compareTo(string[j]) > 0 ) {
						smallest = j;
					}
				}
			}
			if(i != smallest) {//i가 자기 자신이 아닐 때 swap
				tmp = string[i];
				string[i] = string[smallest];
				string[smallest] = tmp;
			}
		}

		for(int i = 0;i < N; i++) {
			System.out.println(string[i]);
		}
	}
}

//선택 정렬
//inplace 알고리즘 중 하나 
//해쉬맵으로 20000가지의 메모리를 사용해도 256MB 아래인 38MB를 썼다. 
