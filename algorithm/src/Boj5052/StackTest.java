package Boj5052;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Point{
	String word;
	int depth;
	public Point(String word, int depth) {
		this.word = word;
		this.depth = depth;
	}
}

public class StackTest {
	
	static ArrayList<String> [] save;
	public static void run(String example) {
		int depth = 0;
		Stack<Point> stack = new Stack<Point>();	
		save = new ArrayList[example.length()/2];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<  example.length()/2 ;i++) {
			save[i] = new ArrayList<String>();
		}
		for(int i = 0;i < example.length();i++) {
			if(example.charAt(i)== '(' || example.charAt(i) == '[' || example.charAt(i) == '{') {
				depth++;
				stack.add(new Point(example.charAt(i)+"", depth));
			}else if(example.charAt(i) == ' ') {
				
			}else if(example.charAt(i)== ')' || example.charAt(i) == ']' || example.charAt(i) == '}') {
				String bottom ="";
				if(example.charAt(i) == ')')
					bottom = "(";
				if(example.charAt(i) == ']')
					bottom = "[";
				if(example.charAt(i) == '}')
					bottom = "{";
				Point point;
				StringBuilder stringBuilder = new StringBuilder();
				String currentString ;
				int currentDepth ;
				int m = 0;
				while(true) {
					point = stack.peek();
					stack.pop();
					currentDepth = point.depth;
					currentString = point.word;
					System.out.println("peek 는 " + point.word );
					if(currentString.equals("(") || currentString.equals("[") || currentString.equals("{")) {
						
					}else
						stringBuilder.insert(0, currentString);
					
					if(currentString.equals(bottom)) {
						System.out.println("arraylist added");
						save[currentDepth].add(stringBuilder.toString());
						break;
					}
				}
				depth--;
			}else {//문자열 
				for(int j = i;true ;j++) {
					if(example.charAt(j)== ' ' || example.charAt(j)== '{' || example.charAt(j)== '(' || example.charAt(j)== '[' || example.charAt(j)== ')' || example.charAt(j) == ']' || example.charAt(j) == '}') {
						if(depth == 0) {
							save[0].add(example.substring(i, j));
						}else
							stack.add(new Point(example.substring(i, j), depth));
						System.out.println(example.substring(i, j));
						i = j-1;
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String example = "((아디다스) 무료(나이키 (풋살화)) 배송) 강남점 (축구)(잔디)";
		StringBuilder stringBuilder = new StringBuilder();
		run(example);
		
		for(int i = example.length()/2 -1;i >= 0 ; i--) {
			System.out.println(save[i].size());
			for(int j =0;j < save[i].size();j++) {
				System.out.println("word is" + save[i].get(j));
			}
		}
		
		System.out.println("hah");
	}

}
