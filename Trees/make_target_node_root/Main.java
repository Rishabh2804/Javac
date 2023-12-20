package make_target_node_root;

import java.util.*;

class TreeNode {
    int data;

    ArrayList<TreeNode> children;
    TreeNode parent;

    TreeNode(int data) {
        this.data = data;
        children = new ArrayList<TreeNode>();
        parent = null;
    }

}

public class Main {

    public static Scanner s = new Scanner(System.in);

    public static TreeNode makeRoot(TreeNode root) {
        if (root == null || root.parent == null)
            return root;

        TreeNode parent = root.parent;
        parent.children.remove(root);
        root.parent = null;

        TreeNode newChild = makeRoot(parent);
        root.children.add(newChild);

        return root;
    }

    public static TreeNode find(TreeNode root, int target) {
        if (root == null)
            return null;

        if (root.data == target)
            return root;

        for (TreeNode child : root.children) {
            TreeNode result = find(child, target);
            if (result != null)
                return result;
        }

        return null;
    }

    public static TreeNode transform(TreeNode root, int target) {
        if (root == null)
            return null;

        TreeNode targetNode = find(root, target);

        if (targetNode == null)
            return root;
        else {
            TreeNode newRoot = makeRoot(targetNode);
            return newRoot;
        }

    }

    public static TreeNode takeInputLevel(int n) {
        System.out.print("Enter data for node no." + n + ": ");
        int data = s.nextInt();

        TreeNode root = new TreeNode(data);

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current = q.remove();
            System.out.println("Enter number of children for node " + current.data + ": ");
            int numChildren = s.nextInt();
            System.out.println();

            for(int i = 0; i < numChildren; i++){
                System.out.println("Enter data for child " + i + ": ");
                int dataChild = s.nextInt();
                TreeNode child = new TreeNode(dataChild);
                current.children.add(child);
                child.parent = current;
                q.add(child);
            }

            System.out.println();
        }

        return root;
    }

    public static void printLevel(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        System.out.println(root.data);

        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            System.out.print(temp.data + ": ");

            for (int i = 0; i < temp.children.size(); i++) {
                TreeNode child = temp.children.get(i);
                System.out.print(child.data + " ");
                q.add(child);

                if (i == temp.children.size() - 1)
                    System.out.println();

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        TreeNode root = takeInputLevel(1);

        printLevel(root);

        System.out.println();

        System.out.print("Enter target: ");
        int target = s.nextInt();

        TreeNode newRoot = transform(root, target);

        printLevel(newRoot);

    }

}
