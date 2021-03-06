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

//탐색 기법중에 하나로 원하는 탐색 범위를 두 부분으로 분할해서 찾는 방식입니다.
//그렇기에 원래의 전부를 탐색하는 탐색 속도에 비해 빠릅니다. 이분 탐색을 하는 방법은
//left, right, mid 값으로 탐색하는 것입니다. mid 의 값은 (left+ right)/2 으로
//잡아주고 우리가 검색하고자 하는 값은 mid값을 비교합니다.
//순서로 말하자면 
// 이분 탐색을 하고자 하면 이미 정렬이 되어있어야 합니다.
//