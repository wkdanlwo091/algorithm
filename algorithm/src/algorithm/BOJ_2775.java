package algorithm;


import java.util.Scanner;

public class BOJ_2775 {

	
	public static void main(String[] args) {
		int T;
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int i = 0;i < T;i++) {
			int k,n;
			k= scan.nextInt();
			n = scan.nextInt();
			int map[][] = new int[k+1][n+1];//0Ãþ ~ kÃþ , 1È£ ~ nÈ£
			for(int y = 0; y<=k; y++) {
				for(int x = 1; x<= n;x++) {
					if(y == 0) {
						map[y][x] = x;
					}else {
						map[y][x] = map[y][x-1] + map[y-1][x]; 
					}
				}
			}
			System.out.println(map[k][n]);
		}
	}
}
