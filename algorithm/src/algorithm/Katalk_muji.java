package algorithm;

import java.util.PriorityQueue;

public class Katalk_muji {
	
	
	static class Food implements Comparable<Food>{
		int food_time;
		int food_num;
		
		public Food(int food_time, int food_num) {
			this.food_time = food_time;
			this.food_num = food_num;
		}
		
		@Override
		public int compareTo(Food target) {//¹ÎÈü
			return this.food_time <= target.food_time ? -1: 1;
		}
	}
	
    public int solution2(int[] food_times, long k) {
        int answer = 0;

        int index = 1;
        int realTime = 0;
        int total = 0;
        for(int i =0 ;i < food_times.length;i++) {
        	total += food_times[i];
        }
        if(total <= k)
        	return -1;
        
        while(true) {//
        	if(food_times[index-1] != 0) {
        		food_times[index-1]--;
        	}else if(food_times[index-1] == 0){
        		realTime--;
        	}
        	index++;
        	if(k == realTime) {
        		answer = --index;
        		break;
        	}
        	realTime++;
        	if(index > food_times.length) {
        		index = index % food_times.length;
        	}
        }
        
        return answer;
    }
    
    public int solution(int[] food_times, long k) {
        int answer = 0;
        
        PriorityQueue<Food> pq = new PriorityQueue<>();
        
        
        for(int i =0 ;i < food_times.length;i++) {
        	pq.offer(new Food(food_times[i], i));

        }
        
        int beforeFood = 0;
        
        while(true) {
        	if()
        	if(k - (pq.peek().food_time-beforeFood) * pq.size() > 0) {
        		k = k - (pq.peek().food_time-beforeFood) * pq.size();
        		pq.poll();
        	
        	}
        	else if(k - (pq.peek().food_time-beforeFood) * pq.size()  == 0) {
        		k = k - (pq.peek().food_time-beforeFood) * pq.size();
        		pq.poll();

        	}else {
        		
        	}
        }
        
		return answer;
    }
    
    public static void main(String[] args) {
    	Katalk_muji a = new Katalk_muji();
    	int[] temp = {2,1,2};
    	
    	System.out.println(a.solution(temp, 5));
    }
}
