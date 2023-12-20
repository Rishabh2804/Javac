import java.util.Scanner;

public class TestClass {
    static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        String message = s.nextLine();
        
        HuffmanTree tree = new HuffmanTree(message);

        String[] codes = tree.getHuffmanCodes();
        for (int i = 0; i < 255; ++i) {
            if (codes[i] != null)
                System.out.println((char)(i) + " : " + codes[i]);
        }

        System.out.println();

        String encodedMessage = tree.getEncodedString();
        System.out.println("Encoded String : " + encodedMessage);

        String decoded = tree.getDecodedMessage();
        System.out.println("Decoded Message : " + decoded);
    }

}
