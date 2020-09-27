package algorithm;

import java.util.Scanner;

public class BOJ_1992 {
	static int N;
	static int map[][];
	
	static String dac(int y, int x, int size) {//divide and conquer
		
		int zero = 0;
		int one = 0;
		for(int i = y;i < y +size;i++) {
			for(int j = x; j < x+ size; j++) {
				if(map[i][j] == 0)
					zero++;
				else 
					one++;
			}
		}

		if(one == size*size) {
			return  "1"; 
		}
		if(zero == size* size) {
			return "0";
		}
			
		String total = "";
		
		String a = dac(y, x, size/2);

		if(a.length() == 1)
			total += a;
		else 
			total += "("+ a + ")";
		
		String b = dac(y, x+size/2, size/2);
		
		if(b.length() == 1)
			total += b;
		else 
			total += "("+ b + ")";

		
		String c = dac(y+size/2, x, size/2);
		
		if(c.length() == 1)
			total += c;
		else 
			total += "("+ c + ")";

		String d = dac(y+size/2 , x+size/2 , size/2);

		if(d.length() == 1) {
			total += d;
		}		
		else 
			total += "("+ d + ")";

		return total;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		map = new int[N+1][N+1];
		String temp = "";
		for(int i = 1 ; i<= N;i++) {
			temp = scan.next();
			for(int j = 1;j <= N;j++) {
				map[i][j] = temp.charAt(j-1) - '0'; 
			}
		}

		String ans = dac(1,1,N);
		if(ans.length() == 1) {
			System.out.println(ans);
		}else 
			System.out.println("(" + ans + ")");
	}
}
