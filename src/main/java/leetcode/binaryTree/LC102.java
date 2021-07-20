package leetcode.binaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return res;
        }

        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                result.add(node.val);
            }
            res.add(new ArrayList<>(result));
            result.clear();
        }
        Collections.reverse(res);
        return res;
    }
}
