package Boj5052;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class StackPoint{
	int value;
	int position; 
	public StackPoint(int value, int position) {
		this.value = value;
		this.position  = position;
	}
}

public class BOJ_2493 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int arr[] = new int[N];
		Stack<Integer> stack = new Stack<Integer>();//최종 출력 스택 
		Stack<StackPoint> stackTemp = new Stack<StackPoint>();// 부스택 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String bfString = bf.readLine();

		int index = 0;
		for(int i= 0;i <bfString.length();i++) {
			if(bfString.charAt(i) >= '1' && bfString.charAt(i) <= '9') {
				arr[index++] = bfString.charAt(i)-'0';
			}
		}
		
		for(int i = N-1; i>=0 ; i--) {
			if(i == 0) {
				stack.add(-1);
				stackTemp.add(new StackPoint(arr[i], i+1));//부스택에 출력스택에 안들어 간것들의 값과 위치저장
				continue;
			}
			if(arr[i-1] >= arr[i]) {//  7 >= 4
 				stack.add(i);// 4입력
			}else {//5 < 4
				stack.add(-1);
				stackTemp.add(new StackPoint(arr[i], i+1));//부스택에 출력스택에 안들어 간것들의 값과 위치저장
			}
		}
		int maxTemp = 0;
		int maxTempPosition = 0;
		while(stack.size() != 0) {
			if(stack.peek() == -1) {
				if(stackTemp.peek().value > maxTemp) {
					System.out.print("0 ");
					maxTemp = stackTemp.peek().value;
					maxTempPosition = stackTemp.peek().position;
				}else {
					System.out.print(maxTempPosition + " ");
				}
				stackTemp.pop();
			}else {
				System.out.print(stack.peek() + " ");
			}
			stack.pop();
		}
	}
}