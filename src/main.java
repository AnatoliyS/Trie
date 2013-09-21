import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.lang.Character;

import BinarySearchTree.BinarySearchTreeNode;
import Trie.*;
import BinarySearchTree.*;

public class main {

	public static void main(String[] args) throws IOException {
		trie = new Trie();
		BST = new BinarySearchTree<Character>();
		Charset encoding = Charset.defaultCharset();
        for (String filename : args) {
            File file = new File(filename);
            handleFile(file, encoding);
        }		
	}
	private static Trie trie;
	private static BinarySearchTree<Character> BST;
	
	private static void handleFile(File file, Charset encoding) throws IOException {
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in, encoding);
             // buffer for efficiency
             Reader buffer = new BufferedReader(reader)) 
        {
             handleCharacters(buffer);
        }
    }

    private static void handleCharacters(Reader reader) throws IOException {
        int currentByte;
        String word = "";
        int differentChars = 0;
        int maxDifferentChars = 0;
        
        while ((currentByte = reader.read()) != -1) {
            char ch = (char) currentByte;
            if(Character.isLetter(ch)){
            	word += ch;
            	BST.insert(ch);
            }else{      	
            	differentChars = BST.getSize();
            	if(maxDifferentChars == differentChars){
            		trie.add(word);
            	}else if(maxDifferentChars < differentChars){
            		trie.clean();
            		maxDifferentChars = differentChars;
            		trie.add(word);
            	}
            	BST.clean();
            	word = "";
            }            
        }
        
        System.out.println("Max difference " + new Integer(maxDifferentChars).toString());
        System.out.println("Words with this difference: ");
        
        List<String> list = trie.getWords();
        for(String s : list){
        	System.out.println(s);
        }
    }
}
