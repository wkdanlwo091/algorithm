package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class BOJ_18258 {
	static int N;
	static String st;
	static int num;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> q = new LinkedList<>();
		StringTokenizer s;

		N = Integer.parseInt(br.readLine());
		for(int i= 0;i< N;i++) {
			s = new StringTokenizer(br.readLine());
			String st = s.nextToken();
			if(st.equals("push")) {
				num = Integer.parseInt(s.nextToken());
				q.addFirst(num);
			}else if(st.equals("front")) {
				if(q.size() != 0) {
					bw.write(q.peekLast() + "\n");
				}
				else {
					bw.write("-1" + "\n");
				}
			}else if(st.equals("back")) {
				if(q.size() != 0)
					bw.write(q.peekFirst() + "\n");
				else {
					bw.write("-1\n");
				}
			}else if(st.equals("size")) {
				bw.write(q.size() + "\n");
			}else if(st.equals("empty")) {
				if(q.isEmpty()) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
			}else if(st.equals("pop")) {
				if(q.isEmpty()) {
					bw.write("-1\n");
				}else
					bw.write(q.pollLast() + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
}
