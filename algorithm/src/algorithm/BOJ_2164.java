package algorithm;

import java.util.Deque;
import java.util.Scanner;
import java.util.LinkedList;

public class BOJ_2164 {
	static int N;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		Deque<Integer> dq = new LinkedList<>();
		
		for(int i =1;i <=N;i++) {
			dq.offerLast(i);
		}
		
		while(dq.size() != 1) {

			dq.removeFirst();
			if(dq.size() == 1)
				break;
			dq.offerLast(dq.pollFirst());
		}
		System.out.println(dq.peekLast());
		
	}
}
