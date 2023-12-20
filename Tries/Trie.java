public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private void add(TrieNode root, String key, int si) {
        if (si >= key.length()) {
            root.isEndOfWord = true;
            return;
        }

        int childIndex = key.charAt(si) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode();
            root.children[childIndex] = child;
        }

        child.words++;

        add(child, key, si + 1);
    }

    public void add(String word) {
        add(this.root, word, 0);
    }

    private boolean search(TrieNode root, String key, int si) {
        if (si >= key.length()) {
            return root.isEndOfWord;
        }

        int childIndex = key.charAt(si) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null)
            return false;
        else {
            return search(child, key, si + 1);
        }

    }

    public boolean search(String word) {
        return search(this.root, word, 0);
    }

    private int getPrefixCount(TrieNode root, String key, int si) {
        if (si >= key.length()) {
            return root.words;
        }

        int childIndex = key.charAt(si) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null)
            return 0;
        else
            return getPrefixCount(child, key, si + 1);
    }

    public int getPrefixCount(String word) {
        return getPrefixCount(root, word, 0);
    }
}
