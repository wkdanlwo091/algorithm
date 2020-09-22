package algorithm;

import java.util.Scanner;

public class BOJ_14888 {
	
	static int N;
	static int arr[];//숫자 값
	static int oper[];//+, -, * , /, 개수
	static long max = -1999999999;
	static long min = 1999999999;
	static int operator[];//숫자 사이에 들어가는 연산자
	static int visit[];//연산자 자리에 방문했나 체크
	
	static void dfs(int cnt) {
		
		if(cnt == N-1) {//cnt가 연산자 마지막 수에 오면 연산자를 출력한다. 
			
//			for(int i= 0;i < N-1;i++) {
//				System.out.print(operator[i] + " ");
//			}
//			System.out.println("");
			long result = arr[0];
			
			for(int i = 0;i< N-1;i++) {
				
				if(operator[i] == 0) {//+ 
					result = result + arr[i+1];
				}else if(operator[i] == 1) {//-
					result = result - arr[i+1];
				}else if(operator[i] == 2) {//*
					result = result * arr[i+1];
				}else if(operator[i] == 3) {// / 나눗셈
					if(result < 0) {
						result =  ( result / arr[i+1]);
					}else if(result == 0){//0/ 3 ==> 0
						result = 0;
					}else if(result > 0)
						result = result / arr[i+1];
				}
			}
			if(result > max) {
				max = result;
			}
			
			if(result < min) {
				min = result;
			}
		}
		
		for(int i= 0;i < N-1;i++) {
			if( visit[i] == 0) {
				
				int j = i;
				while(true) {//연산자가 0이 아닐 때까지 검색
					if(oper[j%4] == 0) {
						
						
						j++;
					}else {
						
						visit[i] = 1;
						operator[cnt] = j%4;// 0 , 1, 2, 3
						oper[j%4]--;
						dfs(cnt+1);
						visit[i] = 0;
						++oper[j%4];

						break;
					}
				}

				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N];
		oper = new int[4];
		
		operator = new int[N-1];
		visit = new int[N-1];
		
		for(int i = 0 ;i < N;i++) {
			arr[i] = scan.nextInt();
		}
		for(int i = 0;i < 4;i++) {
			oper[i] = scan.nextInt();
		}
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}
}