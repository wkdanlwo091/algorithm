package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Katalk_open_chat {
    public String[] solution(String[] record) {
    	Map<String, String> ids = new HashMap<String, String>();//id nickname
        String[] answer = new String[record.length];
        String[] answerWord = new String[record.length];
        String[] temp ;
        
        int answerIndex = 0;
        for(int i = 0 ;i < record.length;i++) {
        	temp = record[i].split(" ");
        	if(temp[0].equals("Enter")) {
        		ids.put(temp[1], temp[2]);
        		answer[answerIndex] = temp[1];
        		answerWord[answerIndex++] = "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.\"";
        		
        	}
        	else if(temp[0].equals("Leave")) {
        		answer[answerIndex] = temp[1];
        		answerWord[answerIndex++] = "´ÔÀÌ ³ª°¬½À´Ï´Ù.\"";

        	}
        	else if(temp[0].equals("Change")) {
        		ids.put(temp[1], temp[2]);
        	}	
        }
        String[] newAnswer = new String[answerIndex];
        for(int i = 0; i < newAnswer.length;i++) {
        	newAnswer[i] = "\"" + ids.get(answer[i]) + answerWord[i];
        }
        return newAnswer;
    }
    
    public static void main(String[] args) {
    	
    	Katalk_open_chat a = new Katalk_open_chat();
    	
    	String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
        		"Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    	
    	a.solution(record);
    	
    }

}
