package algorithm;

import java.util.Scanner;

public class BOJ_1712 {

	public static void main(String[] args) {
		int A,B,C;
		Scanner scan = new Scanner(System.in);
		A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();
		
		double x = (double)A/(double)(C-B);
		
		if(A == 0 && C-B > 0) {
			System.out.println(1);
			return;
		}else if(A == 0 && C-B <= 0) {
			System.out.println(-1);
			return;

		}else if(A != 0 && C-B <= 0) {
			System.out.println(-1);
			return;
		} 
		
		String st = Double.toString(x);
		for(int i =0;i < st.length();i++) {//손익 분기점이 소수인경우
			if(st.charAt(i) == '.' && i+1< st.length() && st.charAt(i+1) != '0') {
				if(st.charAt(i+1)-'0' <5)
					System.out.println(Math.round(x)+1 );
				else if(st.charAt(i+1)-'0'>=5){
					System.out.println(Math.round(x) );
				}
				return;
			}
		}
		
		System.out.println( (int)x+1);
		return;
	}
}
