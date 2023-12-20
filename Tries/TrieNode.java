public class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    int words;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
        words = 0;
    }

}
