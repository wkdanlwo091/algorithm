package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Katalk_4_2 {
	static class Trie{
		
		private TrieNode rootNode;
		private TrieNode backRootNode;//backward 노드
		
		Trie(){
			rootNode = new TrieNode();
			backRootNode = new TrieNode();
		}
		
		void insert(String word) {
			
			
			TrieNode thisNode = this.rootNode;
			
			
			for(int i = 0 ;i < word.length();i++) {
				//해당 단어 갯수가 없으면     // 루트노드 부터 시작
				if(thisNode.wordLength.get(word.length()) == null)
					thisNode.wordLength.put(word.length(), 1);
				else //해당 단어 갯수를 가지고 있으면 더한다. 
					thisNode.wordLength.put(word.length(), thisNode.wordLength.get(word.length()) + 1);
				
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			
			thisNode.setIsLastChar(true);
			
		}
		
		void insertBackward(String word) {
			TrieNode thisNode = this.backRootNode;
			for(int i = word.length()-1 ;i >= 0; i--) {
				//해당 단어 갯수가 없으면     // 루트노드 부터 시작
				if(thisNode.wordLength.get(word.length()) == null)
					thisNode.wordLength.put(word.length(), 1);
				else //해당 단어 갯수를 가지고 있으면 더한다. 
					thisNode.wordLength.put(word.length(), thisNode.wordLength.get(word.length()) + 1);
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			thisNode.setIsLastChar(true);
		}
		
		boolean contains(String word) {
			TrieNode thisNode = this.rootNode;
			for(int i = 0;i < word.length();i++) {
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				if(node == null) {
					return false;
				}
				thisNode = node;
			}
			return thisNode.isLastChar();
		}
		
		boolean containsBackward(String word) {
			TrieNode thisNode = this.rootNode;
			for(int i = word.length()-1;i >= 0;i--) {
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				if(node == null) {
					return false;
				}
				thisNode = node;
			}
			return thisNode.isLastChar();
		}
		
		int howManyChildNodes(String word, int wordLength) {
			TrieNode thisNode = this.rootNode; 
			for(int i = 0;i < word.length();i++){
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				if(node == null) {//??일 때
					break;
				}else {
					
				}
				thisNode = node;
			}
			
			if(thisNode.wordLength.get(wordLength) == null) {
				
			}else {
				return thisNode.wordLength.get(wordLength);
			}
			
			return 0;
		}
		
		int howManyBackChildNodes(String word, int wordLength) {//??apple --> elppa??
			
			TrieNode thisNode = this.backRootNode; 
			
			for(int i = 0;i < word.length();i++){
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				if(node == null) {//??일 때
					break;
				}else {
					
				}
				thisNode = node;
			}
			if(thisNode.wordLength.get(wordLength) == null) {
			}else {
				return thisNode.wordLength.get(wordLength);
			}
			return 0;
		}
		
	}

	static class TrieNode{
		private Map<Character, TrieNode> childNodes = new HashMap<>();
		private Map<Integer, Integer> wordLength = new HashMap<>();//단어 길이에 해당하는게 몇개 있는지 체크
		private boolean isLastChar;
		
		Map<Character, TrieNode> getChildNodes(){
			return this.childNodes;
		}
		
		boolean isLastChar() {
			return this.isLastChar;
		}
		
		void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}
	}
	
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Trie trie = new Trie();
        
        for(int i =0  ;i < words.length;i++) {
        	if(trie.contains(words[i]) == false) {
        		trie.insert(words[i]);
        	}
        	if(trie.containsBackward(words[i]) == false) {
            	trie.insertBackward(words[i]);
        	}
        }
        
        for(int i = 0;i < queries.length;i++) {
        	for(int j = 0 ;j < queries[i].length();j++) {
        		if(queries[i].charAt(j) == '?') { 
                	if( j-1 >=0 &&queries[i].charAt(j-1) != '?') {//fro?? 에서 fro , 5
                		answer[i] = trie.howManyChildNodes(queries[i].substring(0, j), queries[i].length());
                		break;
                	}
                	if(j == queries[i].length() - 1) {//??, ?, 
                		answer[i] = trie.howManyChildNodes(queries[i], queries[i].length());
                	}
        		}else {
        			if(j-1>= 0 && queries[i].charAt(j-1) == '?') {//??apple  
        				answer[i] = trie.howManyBackChildNodes(queries[i].substring(j, queries[i].length()), queries[i].length());// ???o
        				continue;
        			}
        		}
        	}
        }
        for(int i=0 ;i < queries.length;i++) {
        	System.out.println(answer[i]);
        }

        return answer;
    }
	public static void main(String[] args) {
		Katalk_4_2 katalk_4 = new Katalk_4_2();
		String [] words = {"frodo", "front", "frost", "frozen", "frame", "kakao", "a", "aa"};
		String [] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?", "??", "?????", "??odo", "?????"};
		katalk_4.solution(words, queries);
	}
}
