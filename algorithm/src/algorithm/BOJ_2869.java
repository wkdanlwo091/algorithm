package algorithm;
import java.util.Scanner;
public class BOJ_2869 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A, B, V, left = 1, right = 0, mid = 0, result = 0, answer = 0;  /// A = 2, B = 1, V = 5
		A = scan.nextInt();
		B = scan.nextInt();
		V = scan.nextInt();
		
		right = (int) Math.ceil(V/(A-B)) + 1;
		
		while(left <= right) {
			if(A== V) {
				answer = 1;
				break;
			}
			mid = (left + right) /2;
			result = (mid * A) - (mid* B);
			System.out.println("mid is " + mid + " " +result  + " " + (result + A) + " " + V);
			
			if(result + A == V) {
				answer = mid + 1;
				break;
			}else if(result + A > V) {
				right = mid-1;
				answer = mid + 1;
			}else if(result + A < V) {
				left = mid + 1;
			}
		}
		System.out.println(answer);
		
	}
}

//Ž�� ����߿� �ϳ��� ���ϴ� Ž�� ������ �� �κ����� �����ؼ� ã�� ����Դϴ�.
//�׷��⿡ ������ ���θ� Ž���ϴ� Ž�� �ӵ��� ���� �����ϴ�. �̺� Ž���� �ϴ� �����
//left, right, mid ������ Ž���ϴ� ���Դϴ�. mid �� ���� (left+ right)/2 ����
//����ְ� �츮�� �˻��ϰ��� �ϴ� ���� mid���� ���մϴ�.
//������ �����ڸ� 
// �̺� Ž���� �ϰ��� �ϸ� �̹� ������ �Ǿ��־�� �մϴ�.
//