package NiuKe;

import java.util.Stack;

public class NC4 {
    public int sumNumbers (TreeNode root) {

        if(root == null) {
            return 0;
        } else {
            return dfs(root, root.val);
        }
    }

    private int dfs(TreeNode root, int presum) {
        int sum = presum*10 + root.val;
        if(root.left == null && root.right == null) {
            return sum;
        }
        else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}

class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
}
