package Boj5052;

import java.util.Scanner;

public class BOJ_5622 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String string = scan.next();
		int answer = 0;
		for(int i = 0;i< string.length();i++) {
			answer += (string.charAt(i)-65)/3 + 2;
			System.out.println((string.charAt(i)-65)/3 + 2);
		}
		
		answer += string.length();// ���̾�� ���ư���  
		System.out.println(answer);
	}

}
