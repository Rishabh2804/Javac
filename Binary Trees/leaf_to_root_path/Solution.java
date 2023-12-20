package leaf_to_root_path;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private Solution() {
        
    }

    public static List<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            ArrayList<Integer> out = new ArrayList<>();
            out.add(root.data);

            return out;
        }

        List<Integer> left = longestRootToLeafPath(root.left);
        List<Integer> right = longestRootToLeafPath(root.right);

        if (left.size() >= right.size()) {
            left.add(root.data);
            return left;
        } else {
            right.add(root.data);
            return right;
        }

    }

}