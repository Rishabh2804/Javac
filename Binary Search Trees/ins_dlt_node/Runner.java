package ins_dlt_node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BinaryTreeNode<T>{
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data){
        this.data=data;
        left=null;
        right=null;
    }
	

}
public class Runner {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root=null;
		int choice, input;
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			choice = Integer.parseInt(st.nextToken());
			switch (choice) {
			case 1:
				input = Integer.parseInt(st.nextToken());
				Solution.insert(root,input);
				break;
			case 2:
				input = Integer.parseInt(st.nextToken());
				Solution.deleteNode(root,input);
				break;
			default:
				Solution.printTree(root);
				break;
			}

		}
	}
}