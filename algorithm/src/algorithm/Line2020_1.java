package algorithm;

public class Line2020_1 {
    public int solution(int[][] boxes) {
        int answer = 0;
        
        
        for(int i = 0;i < boxes.length;i++) {
        	int box = boxes[i][0];
        	int temp = 0;
        	for(int j = 0;j < boxes.length;j++) {
        		if(box == boxes[j][0]) {
        			temp++;
        		}
        		if(box == boxes[j][1]) {
        			temp++;
        		}
        		if(temp == 2) {
        			break;
        		}
        	}
        	if(temp == 1)
        		answer++;
        	
        }
        return answer;
    }

	
	public static void main(String[] args) {
		
		
		int[][] boxes = {{1, 2}, {2, 1}, {3, 3},{4, 5}, {5, 6}, {7, 8}};
		Line2020_1 line = new Line2020_1();
		line.solution(boxes);
		}

}
