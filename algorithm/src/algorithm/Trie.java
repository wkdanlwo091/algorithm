package algorithm;
import java.util.HashMap;
public class Trie {
	public static void main(String[] args) {
		String tmp = "apple";
		TrieNode root = new TrieNode('*');
		TrieNode prev = root;
		for(int i = 0;i< tmp.length(); i++) {
			char c = tmp.charAt(i);
			TrieNode curr = new TrieNode(c);
			prev = prev.putChild(curr);
		}
	}
}
class TrieNode{
		char c;
		HashMap<Character,TrieNode> children;
		public TrieNode(char c) {
			this.c = c;
			children = new HashMap<Character, TrieNode>();
		}
		TrieNode putChild(TrieNode t) {//트라이의 children 노드에 값이 있는 경우는 바로 return 아닌 경우는 새로 할당
			if(!children.containsKey(t.c)) {
				children.put(t.c, t);
			}
			return children.get(t.c);
		}
		TrieNode getChild(char c) {
			return children.get(c);
		}
}