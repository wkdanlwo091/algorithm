package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1181_2 {
	
	static class Word implements Comparable<Word>{
		String s;
		Word(String s){
			this.s = s;
		}
		@Override
		public int compareTo(Word arg0) {
			int r = s.length() - arg0.s.length();
			if(r == 0) {
				r = s.compareTo(arg0.s);
			}
			return r;
		}
		
	}
	
	public static void main(String[] args) {
		int N;
		ArrayList<Word> arr = new ArrayList<Word>();
		Scanner scan = new Scanner(System.in);	
		N = scan.nextInt();
		String s;
		for(int i = 0;i< N;i++) {
			s = scan.next();
			arr.add(new Word(s));
		}
		Collections.sort(arr);
		
		for(int i = 0;i< N;i++) {
			if(i > 0) {
				if(arr.get(i-1).s.equals(arr.get(i).s)){
				}else
					System.out.println(arr.get(i).s );
			}else
				System.out.println(arr.get(i).s );

		}

	}
}

