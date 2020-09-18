package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Trie3 {

	static class TrieNode3{
		private Map<Character, TrieNode3> childNodes = new HashMap<>();
		private boolean isLastChar;
		
		Map<Character, TrieNode3> getChildNodes(){
			return this.childNodes;
		}
		
		boolean isLastChar() {
			return this.isLastChar;
		}
		
		void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
			
		}
	}
	
	private TrieNode3 rootNode;
	
	Trie3(){
		rootNode = new TrieNode3();
	}
	
	void insert(String word) {
		TrieNode3 thisNode = this.rootNode;
		
		for(int i = 0 ;i <word.length();i++) {
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c->new TrieNode3());
		}
		thisNode.setIsLastChar(true);
	}
	
	boolean contains(String word) {
		TrieNode3 thisNode = this.rootNode;
		
		for(int i= 0 ;i < word.length();i++) {
			char character = word.charAt(i);
			TrieNode3 node = thisNode.getChildNodes().get(character);
			
			
			if(node == null)
				return false;
			
			thisNode = node;
		}
		return thisNode.isLastChar();
	}
}
