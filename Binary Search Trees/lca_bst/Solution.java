package lca_bst;

public class Solution {

   private Solution() {

   }

   public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
      if (root == null)
         return false;

      if (root.data == k)
         return true;
      else if (root.data < k)
         return searchInBST(root.right, k);
      else
         return searchInBST(root.left, k);
   }

   public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
      if (root == null)
         return -1;

      if (root.data == a || root.data == b)
         return root.data;

      if (root.data > a && root.data > b)
         return getLCA(root.left, a, b);

      if (root.data < a && root.data < b)
         return getLCA(root.right, a, b);

      int min = Math.min(a, b);
      int max = Math.max(a, b);
      boolean inleft = searchInBST(root.left, min);
      boolean inright = searchInBST(root.right, max);

      if (inleft && inright) {
         return root.data;
      } else if (inleft) {
         return min;
      } else if (inright) {
         return max;
      } else
         return -1;

   }
}
