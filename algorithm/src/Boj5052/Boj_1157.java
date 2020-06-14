package Boj5052;

import java.util.Scanner;

public class Boj_1157 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String string = scan.next();
		int []arr = new int[26];
		int []overlap = new int[string.length()];
		int charMax = -1;
		
		for(int i = 0 ;i < string.length();i++) {
			if(string.charAt(i)>='a') {
				arr[string.charAt(i)-'a']++;
			}else {
				arr[string.charAt(i) - 'A']++;
			}
		}

		for(int i = 0 ;i < 26;i++) {
			if(arr[i] > charMax) {
				charMax = arr[i];
				overlap[arr[i]]++;
			}else if(arr[i] <charMax) {
				
			}else if(arr[i] == charMax) {
				overlap[arr[i]]++;
			}
		}
		
		int answerMax = -1;
		for(int i = 0;i < string.length();i++) {
			if(overlap[i] > answerMax)
				answerMax = overlap[i];
		}
		
		if(answerMax > 1) {
			System.out.println("?");
		}else if(answerMax == 1) {
			System.out.println(charMax);
		}
	}

}
