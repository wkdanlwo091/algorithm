package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class BOJ_2108 {
	
	static class Common implements Comparable<Common>{
		int num;
		int cnt;
		
		Common(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getCnt() {
			return cnt;
		}

		public void setCnt(int cnt) {
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Common arg0) {//cnt기준으로 내림차순
			int r = -(cnt - arg0.cnt);//cnt순으로 내림차순으로 만들고 
			
			if(r == 0) {//cnt가 같을때는 숫자 크기로 오름차순
				r = num - arg0.num;
			}
			
			return r;
		}
		
	}
	
	public static void main(String[] args) {
		int N, max = 0;
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();//최빈값 제외하고 관련
		Map<Integer, Integer> map = new HashMap<>();//최빈값 찾기 관련
		ArrayList<Integer> most = new ArrayList<>();//최빈값 중복값 넣기
		N = scan.nextInt();
		int temp;
		double sum = 0;
		
		for(int i= 0 ;i < N;i++) {
			temp = scan.nextInt();
			
			if(map.get(temp) == null) {
				map.put(temp, 1);
			}else
				map.put(temp, map.get(temp)+1);
			
			a.add(temp);
			sum += temp;
			
		}
		
		Collections.sort(a);
		
		for(int i: map.keySet()) {
			if(max < map.get(i)) {
				max = map.get(i);
			}
		}
		
		for(int i:map.keySet()) {//최빈값 중복 넣기;
			if(max == map.get(i)) {
				most.add(i);
			}
		}
		
		System.out.println(Math.round(sum/N ) );//소수점 첫째자리에서 반올림한 수
		System.out.println(a.get(N/2));//중앙값
	
		if(most.size() ==1) {
			System.out.println(most.get(0));
		}else {
			Collections.sort(most);
			System.out.println(most.get(1));
		}
		
		System.out.println(a.get(a.size()-1) -a.get(0));
	}

}
