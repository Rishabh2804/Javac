package check_cousins;

public class Solution {

    private Solution() {

    }

    public static boolean isSibling(BinaryTreeNode<Integer> root, int p, int q) {
        if (root == null) {
            return false;
        }

        if (root.left != null && root.right != null) {
            if (root.left.data == p && root.right.data == q)
                return true;
            else if (root.left.data == q && root.right.data == p)
                return true;
            else
                return isSibling(root.left, p, q) || isSibling(root.right, p, q);
        }
        if (root.right != null)
            return isSibling(root.right, p, q);
        else
            return isSibling(root.left, p, q);
    }

    public static int depth(BinaryTreeNode<Integer> root, int node) {
        if (root == null)
            return -1;

        if (root.data == node)
            return 0;

        int left = depth(root.left, node);
        if (left != -1)
            return left + 1;
        else {
            int right = depth(root.right, node);
            if (right != -1)
                return right + 1;
            else
                return -1;
        }

    }

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        if (root == null)
            return false;

        return ((depth(root, p) == depth(root, q)) && (!isSibling(root, p, q)));
    }

    public static boolean isCousin2(BinaryTreeNode<Integer> root, int p, int q) {
        if (root == null)
            return false;

        QueueUsingLL<BinaryTreeNode<Integer>> pendingnodes = new QueueUsingLL<>();
        pendingnodes.enqueue(root);

        int n;
        boolean a = false;
        boolean b = false;
        int c;
        int d;

        while (!pendingnodes.isEmpty()) {
            try {
                n = pendingnodes.size();
                a = b = false;
                c = d = -2;
                for (int i = 0; i < n; ++i) {
                    BinaryTreeNode<Integer> front = pendingnodes.dequeue();
                    int left = -1;
                    int right = -1;
                    if (front.left != null)
                        left = front.left.data;
                    if (front.right != null)
                        right = front.right.data;

                    if (left == p || right == p && c != d) {
                        c = front.data;
                        a = true;
                    }

                    if (left == q || right == q && c != d) {
                        d = front.data;
                        b = true;
                    }

                    if (front.left != null)
                        pendingnodes.enqueue(front.left);

                    if (front.right != null)
                        pendingnodes.enqueue(front.right);
                }

                if (a && b)
                    return true;

            } catch (QueueEmptyException e) {
                return false;
            }
        }

        return a && b;
    }
}
