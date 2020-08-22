package DataStructure.tries;

import java.util.Collections;
import java.util.HashMap;

public class TrieOwn {

	private static final int TRIE_CAPACITY = 26;

	static class TrieNode {
		TrieNode[] childrens = new TrieNode[TRIE_CAPACITY];
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < TRIE_CAPACITY; i++) {
				childrens[i] = null;
			}
		}
	}

	static TrieNode root;

	static void insert(String key) {
		int level;
		int length = key.length();
		int index;
		
		TrieNode pCrawl = root;
		for(level=0;level<length;level++) {
			index = key.charAt(level) - 'a';
			if(pCrawl.childrens[index] == null) {
				pCrawl.childrens[index] = new TrieNode();
			}
			pCrawl = pCrawl.childrens[index];
		}
		pCrawl.isEndOfWord = true;
	}
	
	static boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		
		TrieNode pCrawl = root;
		for(level=0;level<length;level++) {
			index = key.charAt(level) - 'a';
			if(pCrawl.childrens[index] == null) {
				return false;
			}
			pCrawl = pCrawl.childrens[index];
		}
		return (pCrawl!=null &&pCrawl.isEndOfWord);
	}

	public static void main(String[] args) {
		// Input keys (use only 'a' through 'z' and lower case) 
        String keys[] = {"the", "a", "there", "answer", "any", 
                         "by", "bye", "their"}; 
        
        String output[] = {"Not present in trie", "Present in trie"}; 
       
        Collections.synchronizedMap(new HashMap<>());
        root = new TrieNode(); 
        // Construct trie 
        int i; 
        for (i = 0; i < keys.length ; i++) 
            insert(keys[i]); 
       
        // Search for different keys 
        if(search("the") == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(search("these") == true) 
            System.out.println("these --- " + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(search("their") == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(search("thaw") == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
	}

}
