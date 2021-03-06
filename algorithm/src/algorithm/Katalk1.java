package algorithm;

public class Katalk1 {

	
	public StringBuilder RemoveNonLatinLetters(StringBuilder input)
	{
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0;i< input.length();i++) {
	        if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
		           sb.append(input.charAt(i));
	        }else if(input.charAt(i) == '-' || input.charAt(i) == '_' || input.charAt(i) == '.') {
		           sb.append(input.charAt(i));

	        }
	        else if(input.charAt(i) >='0' && input.charAt(i)<= '9') {
		           sb.append(input.charAt(i));
	        }
	        else {
	        }
	    }

	    return sb;
	}
	public StringBuilder dotsToOne(StringBuilder input)
	{
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0;i< input.length();i++) {
	    	if(input.charAt(i) == '.') {
	    		int end = i;
	    		
	    		for(int j = i+1 ; j< input.length();j++) {
	    			if(input.charAt(j) == '.') {
	    				end = j;
	    			}else {
	    				break;
	    			}
	    		}
	    		i = end;
	    		if(i == end) {
	    			sb.append(".");
	    		}else {
	    			sb.append(".");
	    		}
	    		
	    	}else {
	    		sb.append(input.charAt(i));
	    	}
	    }

	    return sb;
	}
	

    public String solution(String new_id) {
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append(new_id);
        
        for(int i =0 ;i< stringBuilder.length();i++) {
        	if(stringBuilder.charAt(i) >=65 && stringBuilder.charAt(i)<=90 ) {
        		stringBuilder.setCharAt(i, (char) (stringBuilder.charAt(i) + 32));
        	}
        }
        //System.out.println(stringBuilder);

        StringBuilder stringBuilder2 = new StringBuilder();
        
        stringBuilder2 = RemoveNonLatinLetters(stringBuilder);
        //System.out.println(stringBuilder2);

        stringBuilder2 = dotsToOne(stringBuilder2);
        //System.out.println(stringBuilder2);
        
        
        //4단계 
        if(stringBuilder2.length()>=1){
            if(stringBuilder2.charAt(0) == '.'  ) {
            	stringBuilder2.deleteCharAt(0);

            }

        }
        if(stringBuilder2.length()>=1) {
            if( stringBuilder2.charAt(stringBuilder2.length()-1) == '.') {
            	stringBuilder2.deleteCharAt(stringBuilder2.length()-1);
            }
        }
       // System.out.println("4단계 " + stringBuilder2);
        
        //5단계 
        
        if(stringBuilder2.length() == 0) {
        	stringBuilder2 = stringBuilder2.append("a");
        }
        //System.out.println("5단게 " + stringBuilder2);
        
        StringBuilder stringBuilder3 = new StringBuilder();
        //6단계 
        if(stringBuilder2.length()>= 16) {
        	stringBuilder3.append(stringBuilder2.substring(0, 15));
            if(stringBuilder3.charAt(stringBuilder3.length()-1) == '.') {
            	stringBuilder3.deleteCharAt(stringBuilder3.length()-1);
            }
        }else {
        	stringBuilder3.append(stringBuilder2) ;
        }
        
        //System.out.println("6단게 " + stringBuilder3);

        //7단ㄱ{ 
        
        
        if(stringBuilder3.length() <= 2) {
        	char temp = stringBuilder3.charAt(stringBuilder3.length()-1);

        	while(true) {
        		stringBuilder3 = stringBuilder3.append(temp);
        		if(stringBuilder3.length() == 3) {
        			break;
        		}
        	}
        		
        }
        
        //System.out.println("7단계 "  +stringBuilder3);
        return stringBuilder3.toString();
    }

	public static void main(String[] args) {
		
		Katalk1 katalk1 = new Katalk1();
		katalk1.solution("...!@BaT#*..y.abcdefghijklm");
		katalk1.solution("z-+.^.");
		katalk1.solution("=.=");
		katalk1.solution("123_.def");
		katalk1.solution("abcdefghijklmn.p");
		
		
		}

}
