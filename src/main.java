import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.lang.Character;

import Trie.*;

public class main {

	public static void main(String[] args) throws IOException {
		trie = new Trie();
		Charset encoding = Charset.defaultCharset();
        for (String filename : args) {
            File file = new File(filename);
            handleFile(file, encoding);
        }		
	}
	private static Trie trie;
	
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
        int r;
        String word = "";
        int different;
        //HashMap<char, boolean> hm = new HashMap<char, boolean>();
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if(Character.isLetter(ch)){
            	word += ch;
            }else{
            	trie.add(word);
            }
            //System.out.println("Do something with " + ch);
        }
    }
}
