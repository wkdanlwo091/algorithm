	package Boj5052;
	
	import java.util.Scanner;
	
	public class Boj_1157 {
	
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			String string = scan.next();
			int []arr = new int[26];
			int []overlap = new int[string.length()+1];
			int charMax = 0;
			char cMax = ' ';
			
			for(int i = 0 ;i < string.length();i++) {
				if(string.charAt(i)>='a') {
					arr[string.charAt(i)-'a']++;
				}else {
					arr[string.charAt(i) - 'A']++;
				}
			}
			
			for(int i = 0 ;i < 26;i++) {
				if(arr[i] > charMax) {// arr[i] > 0 
					charMax = arr[i];
					cMax = (char) ((char)i + 'A');
					overlap[arr[i]]++;
				}else if(arr[i] <charMax) {
					
				}else if(arr[i] == charMax) {// 한단어와 다른 단어가 중복 
					overlap[arr[i]]++;
				}
			}
			
			int answerMax = 0;
			for(int i = 0;i < string.length()+1;i++) {
				if(overlap[i] != 0) {
					answerMax = overlap[i];
				}
			}
			
			if(answerMax > 1) {
				System.out.println("?");
			}else if(answerMax == 1) {
				System.out.println(cMax);
			}
		}
	
	}
