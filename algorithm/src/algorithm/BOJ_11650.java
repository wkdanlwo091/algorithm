package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class BOJ_11650 {

	static class Position implements Comparable<Position>{
		
		int x, y;
		
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Position o) {
			int r = y - o.y;
			if(r == 0) {
				r = x-o.x;
			}
			return r;
		}
	}
	public static void main(String[] args) {
		int N, x, y;
		ArrayList<Position> arr = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for(int i =0 ;i < N;i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			arr.add(new Position(x,y));
		}
		Collections.sort(arr);
		
		for(int i = 0;i < N;i++) {
			System.out.print(arr.get(i).x + " " + arr.get(i).y);
			System.out.println("");
		}
	}
}
