package NiuKe;

public class NC11 {
    public TreeNode sortedArrayToBST (int[] num) {
        // write code here
        if (num == null || num.length == 0) {
            return null;
        }
        return dfs(num, 0, num.length - 1);
    }

    private TreeNode dfs(int[] num, int begin, int end) {
        if (begin <= end) {
            int mid = begin + (end - begin + 1) / 2;

            TreeNode node = new TreeNode(num[mid]);

            node.left = dfs(num, begin, mid - 1);
            node.right = dfs(num, mid + 1, end);

            return node;
        } else {
            return null;
        }
    }
}
