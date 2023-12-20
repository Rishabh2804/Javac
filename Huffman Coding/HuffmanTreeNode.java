public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{    
    char data;    
    int freq;

    HuffmanTreeNode left;
    HuffmanTreeNode right;

    public HuffmanTreeNode() {

    }
    
    public HuffmanTreeNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
    }

    @Override
    public int compareTo(HuffmanTreeNode node) {
        return this.freq - node.freq;
    }
}

