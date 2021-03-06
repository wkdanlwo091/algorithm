package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Katalk3 {
	
 

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[] temp;
        String[] temp2;
        
        String regex = "\\s*\\band\\b";
        String content = "";
        

        for(int i = 0;i < query.length;i++) {
        	
        	content = query[i];
        	
        	content = content.replaceAll(regex, "");

        	int queryTestPoint = 0;
        	if(content.charAt(content.length()-1) == '-') {

        	}else {//query에서 점수 전까지 얻기 
            	for(int j = content.length()-1; ;j--) {
            		
            		if(content.charAt(j) == ' ') {
                    	queryTestPoint = Integer.parseInt(content.substring(j+1, content.length()));
                    	content = content.substring(0, j);
                    	//System.out.println(content + " " + queryTestPoint);
            			break;
            		}
            	}
        	}
        	
        	
        	String infoTemp = "";
        	int infoTestPoint = 0;
        	

        	for(int k = 0;k < info.length;k++) {
        		for(int j = info[k].length()-1; ;j--) {
            		
            		if(info[k].charAt(j) == ' ') {
                    	infoTestPoint = Integer.parseInt(info[k].substring(j+1, info[k].length()));
                    	infoTemp = info[k].substring(0, j);

            			break;
            		}
            	}
            	
            	String[] infoContentTemp = null;
            	String[] contentTemp = null;
            	
    			if(i == 1 || i == 2) {
    				//System.out.println(k + " check " + infoTemp +  " " + content);
    			}

            	
        		if(infoTemp.equals(content)) {
        			if(infoTestPoint >= queryTestPoint) {
        				answer[i]++;
        			}
        		}else {
        			
        			if(i == 1 || i == 2) {
        				//System.out.println("check " + infoTemp +  " " + content);
        			}
        			
        			if(infoTestPoint >= queryTestPoint) {
        				
        				infoContentTemp = infoTemp.split(" ");
            			contentTemp = content.split(" ");

            			for(int x = 0; x<contentTemp.length; x++) {
            				if(contentTemp[x].equals("-")) {
            					
            				}else {
            					if(!contentTemp[x].equals(infoContentTemp[x]))
                				{
                				break;	
                				} 
            				}
            				if(x == contentTemp.length-1) {
                				answer[i]++;
            				}
            			}
            			
        				
        			}else {
        			}

        			
        		}
            	
        		
        	}
        	
        	
        }
        
        
        
        return answer;
    }

	public static void main(String[] args) {
		Katalk3 katalk3 = new Katalk3();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		katalk3.solution(info, query);
	}
}
