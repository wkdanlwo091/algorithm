package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import algorithm.BOJ_2565.Chain;

public class T1 {
	
    static int minAns = 999;
    
    static void tp(int curr,int index , int [] visit,String[] table, StringBuilder sb) {
    	
    	if(index == table.length) {
            return;
    	}
    	
    	
    	if(curr == 0) {
    		
    	}else if(curr == 1) {
    		visit[index] = 1;

    	}
    	System.out.println(curr +" " + index);
		System.out.println();
		for(int i =0 ;i < visit.length;i++) {
			System.out.print(visit[i]);
		}
        	System.out.println();

        int visit2[] = new int[visit.length];
        for(int i= 0 ;i < visit2.length;i++) {
        	visit2[i] = visit[i];
        }
    	tp(0, index+1, visit, table, sb);
    	tp(1, index+1, visit2, table, sb);
    }
    
    static void dp(int curr,int index , int [] visit,String[] table, StringBuilder sb){
    	int sbCheck = 0;//스트링 X개수 체크
        int checked = 0;//스트링 O로 변환 체크 
        int howMany = 0;
        
        if(index == table.length){//종료 조건 
            return;
        }

        
        System.out.println("start");
        System.out.println();
        for(int i= 0;i < visit.length;i++) {
        	System.out.print(visit[i]);
        }
        System.out.println();
        System.out.println("done");
        
        
        if(curr == 0){//no check
        	
        }else if(curr == 1){// yes check 
            for(int i = 0 ;i < sb.length();i++){
                if(table[index].charAt(i) == 'O'){
                    if(sb.charAt(i) == 'O'){
                    }else if(sb.charAt(i) == 'X'){
                        checked = 1;
                        sb.setCharAt(i,  'O');
                    }
                }
            }

            if(checked == 1){//sb가 OOOO인지 체크 
            	visit[index]  = 1;
                for(int i=0 ;i < sb.length();i++){
                    if(sb.charAt(i) == 'O'){
                        sbCheck++;
                    }
                }
            }

        }
        
          
        if(sbCheck == sb.length()){//종료
        	
        	for(int i= 0 ;i < visit.length;i++) {
        		if(visit[i] == 1)
        			howMany++;
        	}
        	
            if(minAns > howMany){
                minAns = howMany;
            }
        }
        
        StringBuilder sb2 = new StringBuilder();
        int [] visit2 = new int[visit.length];
        
        for(int i = 0 ;i < sb.length();i++) {
        	sb2.append(sb.charAt(i));
        }
        
        for(int i= 0 ;i < visit.length;i++) {
        	visit2[i] = visit[i];
        }
        
        dp(0, index+1,  visit,table, sb);
        dp(1, index+1,  visit2,table, sb2);
    }

	public static void main(String[] args) {
        int answer = -1;
        String[] table = {"OXOXO", "OOOOO", "XOXOX"};
        StringBuilder sb = new StringBuilder();
        
        int visit[ ] = new int[table.length];
        for(int i=0 ;i < table[0].length();i++){
            sb.append("X");//XXXX
        }
        dp(0, 0, visit,  table, sb);
        
        visit = new int[table.length];
        sb = new StringBuilder();
        for(int i=0 ;i < table[0].length();i++){
            sb.append("X");//XXXX
        }
        dp(1, 0, visit ,table, sb);
        
        answer = minAns;
        System.out.println("정답은  " + answer);
        
        
        
//        visit = new int[table.length];
//        tp(0,0,visit,table, sb);
//        visit = new int[table.length];
//        tp(1,0,visit,table, sb);
	}

}
