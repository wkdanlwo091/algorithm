package Boj5052;

public class Tests {	
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		String string3 = "three";
		String string2 = "two";
		String string1 = "one";
		stringBuilder.insert(0, string3);
		stringBuilder.insert(0, string2);
		stringBuilder.insert(0, string1);
		System.out.println(stringBuilder.toString());
		
		char test = 'a';
		String mine = test+"";
		System.out.println(mine.length());
		
	}
}
