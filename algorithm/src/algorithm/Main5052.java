package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main5052{
	private static boolean check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		for (int testCase = 0; testCase < T; testCase++) {
			int n = Integer.parseInt(br.readLine()); // 전화번호의 수
			
			int[] number = new int[n]; // 전화번호를 담을 배열
			for (int i = 0; i < number.length; i++) {
				number[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(number); // 큰숫자부터 집어넣기 위해서 정렬

			String[] strNum = new String[n];
			int idx = 0;
			for (int i = number.length-1; i >= 0 ; i--) {
				strNum[idx++] = number[i] + "";
			}
			
			
			Trie root = new Trie('*');
			for (int i = 0; i < strNum.length; i++) {
				check = false;
				String str = strNum[i];
				Trie prev = root;
				for (int j = 0; j < str.length(); j++) {
					char c = str.charAt(j);
					Trie curr = new Trie(c);
					prev = prev.putChild(curr);
				}
				System.out.println(str + " " + check );
				if(!check) break;
			}
			
			if(!check) System.out.println("NO");
			else System.out.println("YES");
		}
	}//end of main
	static class Trie{
		char c;
		HashMap<Character, Trie> children;
		public Trie(char c) {
			this.c = c;
			children = new HashMap<Character, Trie>();
		}
		Trie putChild(Trie t) {
			if(!children.containsKey(t.c)) {
				check = true;
				children.put(t.c, t);
			}
			System.out.println("check is " + check +  " c is " + t.c);
			return children.get(t.c);
		}
		Trie getChild(char c) {
			return children.get(c);
		}
	}
}//end of class
