package algorithm;

import java.util.Scanner;

public class BOJ_11654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String temp = scan.nextLine();
		int wordCount = 0;
		int index = 0;
		for(int i = 0 ; i < temp.length(); i++) {
			if(temp.charAt(i) != ' ') {
				if(index == 0)
					wordCount++;
				index = 1;
			}else if(temp.charAt(i) == ' ' && index == 1) {
				index = 0;
			}
		}
		System.out.println(wordCount);
	}

}
