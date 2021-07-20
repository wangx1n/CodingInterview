package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();

        TreeNode curr = root;

        while(!s.isEmpty() || curr != null) {

            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            if (!s.isEmpty()) {
                TreeNode node = s.pop();
                res.add(node.val);
                curr = node.right;
            }
        }
        return res;
    }
}
