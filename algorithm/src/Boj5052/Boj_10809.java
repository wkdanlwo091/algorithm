package Boj5052;

import java.util.Scanner;

class AlphabetPosition{
	int position;
}

public class Boj_10809 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [] arr = new int[26];
		String string = scan.next();
		for(int i= 0 ;i <26;i++) {
			arr[i]  = -1;
		}
		for(int i = 0 ;i < string.length();i++) {
			if(arr[string.charAt(i) - 'a'] >= 0) {
				
			}else {
				arr[(string.charAt(i)-'a')] = i;
			}
		}
		for(int i =0 ; i< 26;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
