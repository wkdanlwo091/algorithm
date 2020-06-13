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
				N--;// �ߺ��Ǵ� ���ڿ� ���� �Ͽ����Ƿ� ��ü N �� �پ���Ѵ�. 
			}
		}
		
		
		//���ڿ� length() �� 
		for(int i = 0 ;i < N-1;i++) {
			smallest = i;
			for(int j = i+1; j < N;j++) {
				if(string[j].length() < string[smallest].length()) {
					smallest = j;
				}
			}
			if(i != smallest) {//i�� �ڱ� �ڽ��� �ƴ� �� swap
				tmp = string[i];
				string[i] = string[smallest];
				string[smallest] = tmp;
			}
		}
		
		
		
		//���ڿ� ������ ���� ��
		for(int i = 0 ;i < N-1;i++) {
			smallest = i;
			for(int j = i+1; j < N;j++) {
				if(string[smallest].length() == string[j].length()) {
					if(string[smallest].compareTo(string[j]) > 0 ) {
						smallest = j;
					}
				}
			}
			if(i != smallest) {//i�� �ڱ� �ڽ��� �ƴ� �� swap
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
//���� ����
//inplace �˰����� �� �ϳ� 
//