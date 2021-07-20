package leetcode.recur_LC;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC96 {
    public int numTrees(int n) {
        if( n == 0 ) {
            return 0;
        }

        return recur(1, n).size();
    }

    private List<TreeNode> recur(int begin, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (begin > end) {
            result.add(null);
            return result;
        }

        for (int i = begin; i <= end; i++) {
            List<TreeNode> lefts = recur(begin, i - 1);
            List<TreeNode> rights = recur(i + 1, end);

            for (TreeNode leftNodes : lefts) {
                for (TreeNode rightNodes : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNodes;
                    node.right = rightNodes;
                    result.add(node);
                }
            }
        }

        return result;
    }
}
