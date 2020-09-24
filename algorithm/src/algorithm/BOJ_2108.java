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
		public int compareTo(Common arg0) {//cnt�������� ��������
			int r = -(cnt - arg0.cnt);//cnt������ ������������ ����� 
			
			if(r == 0) {//cnt�� �������� ���� ũ��� ��������
				r = num - arg0.num;
			}
			
			return r;
		}
		
	}
	
	public static void main(String[] args) {
		int N, max = 0;
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();//�ֺ� �����ϰ� ����
		Map<Integer, Integer> map = new HashMap<>();//�ֺ� ã�� ����
		ArrayList<Integer> most = new ArrayList<>();//�ֺ� �ߺ��� �ֱ�
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
		
		for(int i:map.keySet()) {//�ֺ� �ߺ� �ֱ�;
			if(max == map.get(i)) {
				most.add(i);
			}
		}
		
		System.out.println(Math.round(sum/N ) );//�Ҽ��� ù°�ڸ����� �ݿø��� ��
		System.out.println(a.get(N/2));//�߾Ӱ�
	
		if(most.size() ==1) {
			System.out.println(most.get(0));
		}else {
			Collections.sort(most);
			System.out.println(most.get(1));
		}
		
		System.out.println(a.get(a.size()-1) -a.get(0));
	}

}
