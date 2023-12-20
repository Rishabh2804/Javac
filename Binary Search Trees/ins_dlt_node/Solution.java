package ins_dlt_node;

public class Solution {
   private Solution() {
      // private constructor
   }

   public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
      if (root == null) {
         root = new BinaryTreeNode<>(data);
         return root;
      }

      if (root.data < data) {
         root.right = insert(root.right, data);
      } else {
         root.left = insert(root.left, data);
      }

      return root;
   }

   private static int minNode(BinaryTreeNode<Integer> root) {
      if (root == null)
         return -1;

      if (root.left == null)
         return root.data;

      return minNode(root.left);
   }

   public static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {
      if (root == null)
         return null;

      if (root.data == key) {
         if (root.left == null && root.right == null)
            return null;
         else if (root.left == null)
            return root.right;
         else if (root.right == null)
            return root.left;
         else {
            int minNode = minNode(root.right);

            root.data = minNode;
            root.right = deleteNode(root.right, minNode);

            return root;
         }
      } else if (root.data < key) {
         root.right = deleteNode(root.right, key);
         return root;
      } else {
         root.left = deleteNode(root.left, key);
         return root;
      }

   }

   public static void printTree(BinaryTreeNode<Integer> root) {
      if (root == null)
         return;

      String out = root.data + ":";
      if (root.left != null)
         out += "L:" + root.left.data + ",";

      if (root.right != null)
         out += "R:" + root.right.data;

      System.out.println(out);

      printTree(root.left);
      printTree(root.right);

   }

}
