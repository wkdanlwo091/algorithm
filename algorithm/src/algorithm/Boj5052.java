package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj5052 {
	public static void main(String[] args) {
		Map<Integer , Integer> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 0 ;i < t; i++) {
			int people = scan.nextInt();
			for(int j = 0 ; j < people ; j++) {
				int phoneNum = scan.nextInt();
				if(map.get(phoneNum) == null) {
					map.put(j, phoneNum);
					String phoneString = Integer.toString(phoneNum);
					for(int k = 0 ; k < phoneString.length(); k++) {
						
					}
				}
				else {
					System.out.println("No");
					break;
				}
			}
		}
	}

}
