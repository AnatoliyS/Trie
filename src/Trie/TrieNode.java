package Trie;

public class TrieNode {	
	public TrieNode(){
		next = new TrieNode[TrieConstant.alphabet];
		for(int i = 0; i < TrieConstant.alphabet; i++){
			next[i] = null;
		}
		leaf = false;
	}
	
	public void deleteChildren(){
		for(int i = 0; i < TrieConstant.alphabet; i++){
			if(next[i] != null)
				next[i].deleteChildren();
			next[i] = null;
		}
	}
	
	TrieNode[] next;
	boolean leaf;
}
