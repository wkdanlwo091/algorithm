package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main5052_2 {
	static boolean check;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int test = 0 ; test< t; test++) {
			int n = scan.nextInt();
			Long phoneNum[] = new Long[n];
			for(int i = 0 ;i< n;i++) {
				phoneNum[i] = scan.nextLong();
			}
			Arrays.parallelSort(phoneNum);
			int idx = 0;
			String strNum[] = new String[n];
			for(int i = phoneNum.length-1;i >= 0 ;i--) {
				strNum[idx++] = phoneNum[i] + "";
			}
			Trie root = new Trie('*');
			for(int i = 0; i <n; i++) {
				check = false;
				Trie prev = root;
				String string = strNum[i];
				for(int j = 0;j < string.length(); j++) {
					Trie current = new Trie(string.charAt(j));
					prev = prev.putChild(current);
				}
				if(check == false) {
					break;
				}
			}
			if(check) {
 				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			//Trie part
		}
	}
	static class Trie{
		char c;
		HashMap<Character, Trie> children;
		public Trie(char c) {
			this.c = c;
			children = new HashMap<Character, Trie>();
		}
		Trie putChild(Trie t) {
			if(!t.children.containsKey(t.c) ) {
				check = true;
				children.put(t.c, t);
			}
			return children.get(t.c);
		}
		Trie getChild(char c) {
			return children.get(c);
		}
	}
}
