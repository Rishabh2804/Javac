package pattern_matching;
import java.util.ArrayList;

class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}

    private void add(TrieNode root,String word){
        if(word.length()==0){
            root.isTerminating=true;
            return;
        }
        int childIndex=word.charAt(0) -'a';
        TrieNode child=root.children[childIndex];
        if(child==null){
            child=new TrieNode(word.charAt(0));
            root.children[childIndex]=child;
        }

        add(child,word.substring(1));
    }
    
    public void add(String word){
       add(root,word);    
    }

	
}

public class Solution{

    public static boolean patternMatching(Trie t,ArrayList<String> vect, String pattern) {
        if(pattern.length()==0)
            return false;
        
        
        for(int i=0;i<vect.size();++i){
            String str=vect.get(i);
            if(str==null)
                continue;
            
            for(int j=0;j<str.length();++j){
                t.add(str.substring(j));
            }
        }
        
        return t.search(pattern);       
        
	}

}