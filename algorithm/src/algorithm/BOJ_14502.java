package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int y, x;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class BOJ_14502 {
	static int[][] map;
	static int[][] tmpMap;
	static int N, M;
	static int[] xAt = { 1, -1, 0, 0 };
	static int[] yAt = { 0, 0, 1, -1 };
	static int maxSafe = -100;
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		int bfsMap[][];
		int bfsVisit[][];
		bfsMap = new int[N][M];
		bfsVisit = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bfsMap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (bfsMap[i][j] == 2  && bfsVisit[i][j] == 0) {// ���̷��� ����
					q.offer(new Point(i, j));
					while (!q.isEmpty()) {
						
						Point temp = q.poll();
						bfsVisit[temp.y][temp.x] = 1;
						bfsMap[temp.y][temp.x] = 2;

						for (int k = 0; k < 4; k++) {
							int nextY = temp.y + yAt[k];
							int nextX = temp.x + xAt[k];
							if (nextY < N && nextY >= 0 && nextX < M && nextX >= 0 && bfsVisit[nextY][nextX] == 0 && bfsMap[nextY][nextX] == 0) {
								q.offer(new Point(nextY, nextX));
							}
						}
					}
				}
			}
		}
		// �� ���������� ���� ����.
		int safe = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (bfsMap[i][j] == 0) {
					safe++;
				}
			}
		}
		maxSafe = Math.max(safe, maxSafe);
	}
	public static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();
			return ;
		}
		for(int i = 0;i< N;i++) {
			for(int j = 0; j< M;j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();

		map = new int[N][M];
		tmpMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(1);
					map[i][j] = 0;
				}
			}
		}
		
		System.out.println(maxSafe);
	}
}
//dfs --> �̷θ� Ž���� �� �� �������� ���ٰ� ���̻� �� �� ������
//���� ����� ������� ���ƿͼ� �� ������ ���� �ٸ� �������� �ٽ� Ž��
//depth first search : �а� ���� depth�ְ� �˻�
//����ϴ� ��� : ��� ��带 �湮�ϰ��� �� �� ���� ����� �����Ѵ�.
//��Ʈ��ŷ