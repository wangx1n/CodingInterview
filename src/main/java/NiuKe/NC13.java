package NiuKe;

public class NC13 {
    private int max = 0;
    public int maxDepth (TreeNode root) {
        // write code here
        if (root == null) {
            return max;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return preSum;
        }
        preSum += 1;
        if (preSum > max) {
            max = preSum;
        }
        dfs(root.left, preSum);
        dfs(root.right, preSum);
        return max;
    }
}
