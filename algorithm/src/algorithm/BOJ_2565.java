package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2565 {
	
	int answer;
	
	static class Chain implements Comparable<Chain> {
		int A, B;
		
		Chain(int A, int B){
			this.A = A;
			this.B = B;
		}
		
	    @Override
	    public int compareTo(Chain num) {
	        if(this.A > num.A) {
	            return 1; // x에 대해서는 오름차순
	        }else if(this.A == num.A) {
	        	return 0;
	        }
	        else if(this.A == num.A) {
	        }
	        return -1;
	    }

		public int getA() {
			return A;
		}

		public void setA(int a) {
			A = a;
		}

		public int getB() {
			return B;
		}

		public void setB(int b) {
			B = b;
		}
	    

	}
	int dp() {
		return answer;
	}
	BOJ_2565(ArrayList<Chain>  chain){
		answer =0;
		int num = chain.size();
		int dp[] = new int[chain.size()];
		int max = -1;
		for(int i= 0;i < num;i++) {
			if(dp[i] == 0) {
				dp[i] = 1;
			}
			for(int j = 0 ;j < i;j++) {
				if(chain.get(j).B < chain.get(i).B) {
					System.out.println("test " + chain.get(i).A + " " + chain.get(i).B);
					if(dp[j]+1 > dp[i]) {
						dp[i] = dp[j]+ 1;
					}
				}
			}
		}
		for(int i = 0 ;i < chain.size();i++) {
			answer = Math.max(dp[i], answer);
		}
	}
	
	public static void main(String[] args) {
		int N;
		int A[] = new int[100];
		int B[] = new int[100];
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		ArrayList<Chain> chain = new ArrayList<Chain>();
		
		int a,b;
		for(int i= 0;i < N;i++) {
			a = scan.nextInt();
			b = scan.nextInt();
			chain.add(new Chain(a,b));
		}
		Collections.sort(chain);		
		
		BOJ_2565 c = new BOJ_2565(chain);
		System.out.println(chain.size() - c.dp());
	}
}
