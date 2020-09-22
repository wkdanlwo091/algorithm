package algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays; 

public class Katalk2 {

	static class Person implements Comparable{
		String letters;
		int times;
		
		public Person(String letters, int times) {
			super();
			this.letters = letters;
			this.times = times;
		}

		public String getLetters() {
			return letters;
		}

		public void setLetters(String letters) {
			this.letters = letters;
		}

		public int getTimes() {
			return times;
		}

		public void setTimes(int times) {
			this.times = times;
		}

		@Override
		public int compareTo(Object o) {
			
	        int compareNum=((Person)o).getTimes();
	        
	        //desceding order
	        return compareNum - this.times;
		}
		

	}
		  static void initiate(String s, Map<String, Integer> temp)
		  {
		    combo("", s, temp);
		  }

		  static void combo(String prefix, String s, Map<String, Integer> temp)
		  {
		    int N = s.length();

	        
	        StringBuilder input1 = new StringBuilder(); 
	  
	        // append a string into StringBuilder input1 
	        input1.append(prefix); 
	  
	        // reverse StringBuilder input1 
	        input1 = input1.reverse(); 
	  
	        String input2 = input1.toString();//stringBuilder to String 
		    
		    //System.out.println("yes " + prefix);
		    if(prefix.equals("")){
		    	
		    }else {
		    	//System.out.println("start " + prefix + " " + prefix.length());
		    	if(temp.get(prefix) == null ) {//WX
		    		
		    		if(temp.get(input2) != null) {
		    			//flip�Ѱ� ������ add���� �ʴ´�. 
		    			temp.put(input2, temp.get(input2)+ 1);
		    		}else {
			    		temp.put(prefix, 1);
		    		}
		    	}else {
		    		temp.put(prefix, temp.get(prefix) + 1);
		    	}
		    }
		    
		    for (int i = 0 ; i < N ; i++)
		      combo(prefix + s.charAt(i), s.substring(i+1),  temp);
		  }
	
		  
		  
		    public static String sortString(String inputString) 
		    { 
		        // convert input string to char array 
		        char tempArray[] = inputString.toCharArray(); 
		          
		        // sort tempArray 
		        Arrays.sort(tempArray); 
		          
		        // return new sorted string 
		        return new String(tempArray); 
		    } 

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        Map<String, Integer> temp = new HashMap<>();
        ArrayList<Person> tempAnswer = new ArrayList<>();
        Map<Integer, Integer> myCourse = new HashMap<>();
   	    ArrayList<String> myAnswer = new ArrayList<>();

        
        for(int i = 0;i < course.length;i++) {
        	myCourse.put(course[i], 1);
        }
        
        for(int i = 0 ; i < orders.length;i++) {
        	initiate(orders[i], temp);
        }
        
        for (Map.Entry<String,Integer> entry : temp.entrySet())  {
//            System.out.println("Key = " + entry.getKey() + 
//                             ", Value = " + entry.getValue()); 
            
            for(int i = 0;i < course.length; i++) {// 1 2 3
            	
            	if(course[i] == entry.getKey().length()) {
            		tempAnswer.add(new Person(entry.getKey(), entry.getValue()));
            	}
            	
            }
        }

 	   Collections.sort(tempAnswer);
 	   

 	   
 	   for(int i = 0;i < tempAnswer.size(); i++) {
 		   System.out.println(tempAnswer.get(i).letters + " "+ tempAnswer.get(i).getTimes());
 	   }
 	   
 	   
 	   int max = 0;
        for(int i= 0;i <tempAnswer.size();i++) {
        	
        	
        	//myCourse�� �ؽ������� course�� ���� ��
        	if(myCourse.get(tempAnswer.get(i).getLetters().length()) != null) {
        		
            	if(myCourse.get(tempAnswer.get(i).getLetters().length()) == 1) {//
            		//AC
            		
            		if(tempAnswer.get(i).getTimes() >1) {
                		myAnswer.add(tempAnswer.get(i).getLetters());
                		myCourse.put(tempAnswer.get(i).getLetters().length(), tempAnswer.get(i).getTimes());
            		}
            		
            		//System.out.println(" start  " +tempAnswer.get(i).getLetters());
            	}else if(myCourse.get(tempAnswer.get(i).getLetters().length()) != 1){
            		
            		//System.out.println(tempAnswer.get(i).getTimes() +  " " + tempAnswer.get(i).getLetters());
            		if(myCourse.get(tempAnswer.get(i).getLetters().length()) == tempAnswer.get(i).getTimes()) {
                		myAnswer.add(tempAnswer.get(i).getLetters());
            		}else {
            			
            		}

            	}
        	}else if(myCourse.get(tempAnswer.get(i).getLetters().length()) == null) {
        		
        	}
        	
        	
        	
        }
        
        
        Collections.sort(myAnswer);

        answer = new String[myAnswer.size()];

        
        for(int i = 0 ;i < myAnswer.size();i++) {
        	//System.out.println(myAnswer.get(i));
        	answer[i] = sortString(myAnswer.get(i));
        }
        
        
        
        
        return answer;
    }

	public static void main(String[] args) {
		
		Katalk2 katalk2 = new Katalk2();
		String[] temp = {"XYZ", "XWY", "WXA"};
		int[] temp2 = {2,3,4};
		katalk2.solution(temp, temp2);
		
		}

}