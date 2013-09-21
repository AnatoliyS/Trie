package Trie;

import java.util.*;

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
	
	public List<String> getWords(){
		list = new ArrayList<String>();		
		getWordsHelper(root, "");
		return list;
	}
	
	private void getWordsHelper(TrieNode current, String s){
		if(current.leaf){
			list.add(s);
		}else{
			for(int i = 0; i < TrieConstant.alphabet; i++){
				if(current.next[i]  != null){
					char ch = (char) (i + TrieConstant.lowLetter);
					getWordsHelper(current.next[i], s + ch);
				}
			}
		}
	}
	
	private TrieNode root;
	private List<String> list;
	private int size;	
}
