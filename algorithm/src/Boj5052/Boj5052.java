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
			
			Trie root = new Trie('*');//루트 노드 
			
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
		char c;//들어오는 한개의 숫자 value
		HashMap<Character, Trie> children;//trie 트리의 key는 문자고  value는 자식노드인 Trie이다.  
		public Trie(char c){//Trie이의 생성자 
			this.c = c;
			children = new HashMap<Character, Trie>();
		}
		Trie putChild(Trie t) {// 자식노드를 넣는다.
			if(!t.children.containsKey(t.c)) {//자식이 c문자를 가지고 있지 않다면 자식노드에 c를 할당한다. 
				check = true;
				children.put(t.c, t);
			}
			return children.get(t.c);//자식을 갖고 있다면 check이 false다 
		}
		Trie getChild(char c) {//자식노드를 return 한다. 
			return children.get(c);
		}
	}
}
