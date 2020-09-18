package algorithm;

import java.util.HashMap;
import java.util.Map;


public class Trie2 {
		
	static final int ALPHABET_SIZE = 26;
	static TrieNode root;
	
	static class TrieNode{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		
		boolean isEndOfWord;
		
		TrieNode() {
			isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) 
                children[i] = null; 
			
		}
	}
	
}
