package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.LinkedList;
public class Line2020_2 {

	
    public int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        Deque<Integer> test = new ArrayDeque<Integer>();
        
        LinkedList<Integer> ll = new LinkedList<Integer>();//우선순위 list

        for(int i =0 ;i < ball.length;i++) {
        	test.add(ball[i]);
        }
        
        
        
        int ballIndex = 0;
        for(int i = 0;i< order.length;i++) {
        	
        		if(ll.size() != 0) {//우선순위 있을 때
        			for(int j = 0 ;j < ll.size();j++)
        			{
        				//System.out.println( "mine " + ll.get(j) + " " + test.peekFirst() + " " + test.peekLast() );
            			if(test.peekFirst() == ll.get(j) ) {
                    		answer[ballIndex++] = test.pollFirst();
                    		ll.remove(j);
                    		j = -1;
                    		//System.out.println( "0 " + answer[ballIndex-1]);
                    	}
            			else if(test.peekLast() == ll.get(j)) {
                    		answer[ballIndex++] = test.pollLast();
                    		ll.remove(j);
                    		j = -1;
                    		//System.out.println(" -0 " + answer[ballIndex-1]);
                    	} 
        				
        			}        			
        		} 
        			
            	if(test.peekFirst() == order[i]  ) {
            		answer[ballIndex++] = test.pollFirst();
            		//System.out.println( " 1 " + answer[ballIndex-1] + " " + test.peekLast());
            	}else if(test.peekLast() == order[i]) {
            		answer[ballIndex++] = test.pollLast();
            		//System.out.println( "2 "  + answer[ballIndex-1]);
            	}else {
            		ll.addLast(order[i]);
            		//System.out.println(" start " + order[i]);
            	}
            	
            	
            	
            	
        	}
        
        
    	//System.out.println( );


        return answer;
    }

	
	public static void main(String[] args) {
		
		int[] ball = {11, 2, 9, 13, 24};
		int [] order = {9, 2, 13, 24, 11};	
		int[] ball2 = {1, 2, 3, 4, 5, 6};
		int [] order2 = {6, 2, 5, 1, 4, 3};	
		Line2020_2 line2020_2 = new Line2020_2();
		line2020_2.solution(ball , order );
		
		}

}
