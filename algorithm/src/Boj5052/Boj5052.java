package Boj5052;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj5052 {
	static boolean check = false;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 0 ;i < t;i++) {
			int n = scan.nextInt();
			long phoneNum[] = new long[n];
			for(int j = 0 ;j < n;j++) {
				phoneNum[j] = scan.nextLong();
			}
			Arrays.parallelSort(phoneNum);
			
			String[] strNum = new String[n];// 911 , 97625999, 91125426
			int idx = 0;
			for(int j = phoneNum.length - 1 ; j >=0 ;j--) {
				strNum[idx++]  = phoneNum[j] + "";
			}
			
			Trie root = new Trie('*');//��Ʈ ��� 
			
			for(int j = 0 ; j < strNum.length; j++) {
				check = false;
				String str = strNum[j];
				Trie prev = root;
				for(int k = 0 ;k < str.length();k++) {
					char c = str.charAt(k);
					Trie current = new Trie(c);
					prev = prev.putChild(current);
				}
				if(!check)break;
			}
			if(!check)System.out.println("NO");
			else System.out.println("YES");
		}
	}
	static class Trie{
		char c;//������ �Ѱ��� ���� value
		HashMap<Character, Trie> children;//trie Ʈ���� key�� ���ڰ�  value�� �ڽĳ���� Trie�̴�.  
		public Trie(char c){//Trie���� ������ 
			this.c = c;
			children = new HashMap<Character, Trie>();
		}
		Trie putChild(Trie t) {// �ڽĳ�带 �ִ´�.
			if(!t.children.containsKey(t.c)) {//�ڽ��� c���ڸ� ������ ���� �ʴٸ� �ڽĳ�忡 c�� �Ҵ��Ѵ�. 
				check = true;
				children.put(t.c, t);
			}
			return children.get(t.c);//�ڽ��� ���� �ִٸ� check�� false�� 
		}
		Trie getChild(char c) {//�ڽĳ�带 return �Ѵ�. 
			return children.get(c);
		}
	}
}