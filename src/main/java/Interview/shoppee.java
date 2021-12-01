package Interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class shoppee {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        ArrayList<Integer> result = post(node1);
        for (Integer res : result) {
            System.out.print(res + ",");
        }
    }

    public static ArrayList<Integer> post(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode last = null;
        TreeNode top = null;

        while (!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.offerLast(root);
                root = root.left;
            }
            top = stack.peekLast();
            if (top.right == null || top.right == last) {
                ans.add(top.val);
                stack.pollLast();
                last = top;
            } else {
                root = top.right;
            }
        }
        return ans;
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
