package bst_tree_traversals;

public class BinarySearchTree {

   BinaryTreeNode<Integer> root;

   public BinaryTreeNode<Integer> add(BinaryTreeNode<Integer> root, int data) {
      if (root == null) {
         root = new BinaryTreeNode<Integer>(data);
         return root;
      }

      if (root.data < data) {
         root.right = add(root.right, data);
      } else {
         root.left = add(root.left, data);
      }

      return root;
   }

   public void insert(int data) {
      this.root = add(this.root, data);
   }

   public BinaryTreeNode<Integer> minNode(BinaryTreeNode<Integer> root) {
      if (root == null || root.left == null)
         return root;

      return minNode(root.left);
   }

   public BinaryTreeNode<Integer> delete(BinaryTreeNode<Integer> root, int data) {
      if (root == null)
         return null;

      if (root.data == data) {
         if (root.left == null && root.right == null)
            return null;
         else if (root.left == null)
            return root.right;
         else if (root.right == null)
            return root.left;
         else {
            BinaryTreeNode<Integer> minNode = minNode(root.right);

            root.data = minNode.data;
            root.right = delete(root.right, minNode.data);

            return root;
         }
      } else if (root.data < data) {
         root.right = delete(root.right, data);
         return root;
      } else {
         root.left = delete(root.left, data);
         return root;
      }

   }

   public void remove(int data) {
      this.root = delete(this.root, data);
   }

   private void print(BinaryTreeNode<Integer> root) {
      if (root == null)
         return;

      String out = root.data + ":";
      if (root.left != null)
         out += "L:" + root.left.data + ",";

      if (root.right != null)
         out += "R:" + root.right.data;

      System.out.println(out);

      print(root.left);
      print(root.right);

   }

   public void printTree() {
      print(this.root);

   }

   private boolean hasdata(BinaryTreeNode<Integer> root, int data) {
      if (root == null)
         return false;
      else if (root.data == data)
         return true;
      else {
         if (root.data < data)
            return hasdata(root.right, data);
         else
            return hasdata(root.left, data);
      }
   }

   public boolean search(int data) {
      return hasdata(this.root, data);
   }

}
