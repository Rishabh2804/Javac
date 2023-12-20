import java.util.PriorityQueue;

public class HuffmanTree {

    private static final char ROOT_DATA = '+';
    private static final char DUMMY_NODE_DATA = '*';

    private static final char NULL_CHAR = '\0';
    private static final char LEFT_MOVE = '0';
    private static final char RIGHT_MOVE = '1';

    private HuffmanTreeNode root;
    private String[] huffmanCodes;
    private String encodedString;

    public HuffmanTree() {

    }

    public HuffmanTree(String msg) {
        buildTree(msg);

        huffmanCodes = new String[255];
        assignCodes(root, "" + ROOT_DATA);

        encode(msg);
    }

    public String getEncodedString() {
        return encodedString;
    }

    public String[] getHuffmanCodes() {
        return huffmanCodes;
    }

    public String getDecodedMessage() {

        StringBuilder message = new StringBuilder();
        int i = 0;
        while (i < encodedString.length()) {
            char c = getChar(i, encodedString, root);
            if (c == NULL_CHAR || huffmanCodes[c] == null)
                return null;

            message.append(c);
            i += huffmanCodes[c].length();
        }

        return message.toString();
    }

    private char getChar(int i, String encodedString, HuffmanTreeNode root) {
        if (root == null)
            return NULL_CHAR; // should never happen

        if (root.data != ROOT_DATA && root.data != DUMMY_NODE_DATA)
            return root.data;

        if (encodedString.charAt(i) == LEFT_MOVE)
            return getChar(i + 1, encodedString, root.left);
        else if (encodedString.charAt(i) == RIGHT_MOVE)
            return getChar(i + 1, encodedString, root.right);
        else
            return NULL_CHAR;
    }

    private void buildTree(String msg) {
        if (msg == null || msg.length() == 0)
            return;

        char[] freq = new char[255];
        for (int i = 0; i < msg.length(); ++i)
            freq[msg.charAt(i)]++;

        PriorityQueue<HuffmanTreeNode> pq = new PriorityQueue<>();
        for (int i = 0; i < 255; ++i) {
            if (freq[i] == 0)
                continue;

            pq.add(new HuffmanTreeNode((char) i, freq[i]));
        }

        if (pq.size() == 1) {
            root = new HuffmanTreeNode(ROOT_DATA, pq.peek().freq);
            root.left = pq.poll();
            return;
        }

        while (pq.size() > 1) {
            HuffmanTreeNode node1 = pq.poll();
            HuffmanTreeNode node2 = pq.poll();

            HuffmanTreeNode merged = new HuffmanTreeNode(DUMMY_NODE_DATA, node1.freq + node2.freq);
            merged.left = node1;
            merged.right = node2;

            pq.add(merged);
        }

        root = pq.poll();
        root.data = ROOT_DATA;
    }

    private void assignCodes(HuffmanTreeNode root, String initialCode) {
        if (root == null)
            return;

        if (root.data == ROOT_DATA) {
            assignCodes(root.left, "" + LEFT_MOVE);
            assignCodes(root.right, "" + RIGHT_MOVE);
            return;
        }

        if (root.data != DUMMY_NODE_DATA)
            huffmanCodes[root.data] = initialCode;

        assignCodes(root.left, initialCode + LEFT_MOVE);
        assignCodes(root.right, initialCode + RIGHT_MOVE);
    }

    private void encode(String msg) {
        StringBuilder encoder = new StringBuilder();
        for (int i = 0; i < msg.length(); ++i)
            encoder.append(huffmanCodes[msg.charAt(i)]);

        encodedString = encoder.toString();
    }

}
