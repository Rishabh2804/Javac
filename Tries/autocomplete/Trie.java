package autocomplete;
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

public class Trie {
	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
	
	public static void print(String str,TrieNode t){
		if(t==null)
			return;

        String curr=str + t.data;
        if(t.isTerminating){
            System.out.println(curr);
        }
        
        for(int i=0;i<26;++i){
            TrieNode child=t.children[i];
            if(child!=null)
                print(curr,child);            
            
        }
        
    }

	public void autoComplete(ArrayList<String> input, String word) {
        if(input.size()==0){    
            return;
        }
        
        for(int i=0;i<input.size();++i){
            this.add(input.get(i));
        }
        if(word.length()==0){
			print("", root);
			return;
		}

        TrieNode t=root;

		String str=word;

		while(!str.isEmpty()){
			int childIndex=str.charAt(0) - 'a';
			TrieNode temp=t.children[childIndex];
			if(temp==null){
				return;
			}
			t=temp;

			if(str.length()==1){
				break;
			}
			str=str.substring(1);
			
		}

		print(word.substring(0,word.length()-1), t);
    }

}