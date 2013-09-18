package Trie;

public class Trie {
	public Trie(){
		root = new TrieNode();
		size = 0;
	}
	public void clean(){
		root.deleteChildren();
		root = new TrieNode();
		size = 0;
	}
	public void add(String s){
		TrieNode current = root;
		for(int i = 0; i < s.length(); i++){
			if(current.next[s.charAt(i) - TrieConstant.lowLetter]  == null){
				current.next[s.charAt(i) - TrieConstant.lowLetter] = new TrieNode();
			}
			current = current.next[s.charAt(i) - TrieConstant.lowLetter];
		}
		current.leaf = true;
		size++;
	}
	public boolean find(String s){
		TrieNode current = root;
		for(int i = 0; i < s.length(); i++){
			if(current.next[s.charAt(i) - TrieConstant.lowLetter]  == null){
				return false;
			}
			current = current.next[s.charAt(i) - TrieConstant.lowLetter];
		}
		return current.leaf;
	}
	
	TrieNode root;
	int size;	
}
