package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1931 {
	static int N;
	static class Time implements Comparable<Time>{
		
		int start;
		int end; 
		
		Time(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override//�������� 
		public int compareTo(Time arg0) {
			if(end == arg0.end) {//������ �ð��� ������ �����ϴ� �ð����� �������� ����
				return start - arg0.start;
			}
			return end - arg0.end;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		int max = 0;
		PriorityQueue<Time> pq = new PriorityQueue<Time>();
		int start, end = 0, cnt = 0;
		
		for(int i = 0;i<N;i++) {
			start = scan.nextInt();
			end = scan.nextInt();
			pq.add(new Time(start, end));
		}
		end = 0;
		for(int i= 0 ;i < N;i++) {
			Time a = pq.poll();
			if(a.start >= end) {
				end = a.end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}