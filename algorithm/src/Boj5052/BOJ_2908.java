package Boj5052;

import java.util.Scanner;

public class BOJ_2908 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String A = scan.next();
		String B = scan.next();
		StringBuilder AA =  new StringBuilder();
		StringBuilder BB = new StringBuilder();
		
		for(int i = A.length()-1;i >= 0;i--) {
			AA.append(A.charAt(i));
		}
		for(int i = B.length()-1;i >= 0;i--) {
			BB.append(B.charAt(i));
		}

		if(Integer.parseInt(AA.toString()) > Integer.parseInt(BB.toString())) {
			System.out.println(AA.toString());
		}
		else {
			System.out.println(BB.toString());
		}
	}

}
