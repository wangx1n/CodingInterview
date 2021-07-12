package NiuKe;

import java.util.LinkedList;
import java.util.Queue;

public class NC16 {
    public boolean isSymmetric (TreeNode root) {
        // write code here
        if( root == null) {
            return true;
        }
        return isEqual(root.left, root.right);
    }
    private boolean isEqual(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }else if (leftNode == null || rightNode == null) {
            return false;
        }else if (leftNode.val != rightNode.val){
            return false;
        }else {
            return isEqual(leftNode.left, rightNode.right) && isEqual(leftNode.right, rightNode.left);
        }
    }
}
