package algorithm;

import java.util.Scanner;

public class BOJ_1541 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a;
		
		a = scan.next();
		
		int sum = 0;
		int start = 0;
		
		for(int i = 0 ;i< a.length();i++) {
			
			if(i == a.length()-1) {// + �϶� ������
					sum+= Integer.parseInt(a.substring(start, i+1));
			}
			
			if(a.charAt(i) == '+') {//+ �϶� + 
				
				sum += Integer.parseInt(a.substring(start, i));
				start = i+1;
				
			}else if(a.charAt(i) == '-') {//+ �϶� - ������ ��
				
				sum += Integer.parseInt(a.substring(start, i));
				start = i+1;
				int j = i+1;
				
				while(true) {
					if(j == a.length()-1){//���ڶ��� �ٴٶ��� ��
						sum -= Integer.parseInt(a.substring(start, j+1));
						i = j;
						break;
					}
					if(a.charAt(j) == '+') {
						sum -= Integer.parseInt(a.substring(start, j));//-�� ����
						start = j+1;
					}else if(a.charAt(j) == '-') {//-�϶� -������ ��
						sum -= Integer.parseInt(a.substring(start, j));
						start = j+1;
					}
					j++;
				}
				
			}
				
		}
		
		System.out.println(sum);
		
	}
}