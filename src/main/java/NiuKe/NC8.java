package NiuKe;

import java.util.ArrayList;
import java.util.Stack;

public class NC8 {
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int tempSum = 0;
        ArrayList<Integer> tempRes = new ArrayList<>();
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            tempRes.add(node.val);

            tempSum += node.val;
            if(node.left == null && node.right == null && tempSum == sum) {
                tempSum -= node.val;
                ArrayList<Integer> newRes = new ArrayList<>();
                for (int i = 0;i < newRes.size();i++) {
                    newRes.add(tempRes.get(i));
                }
                res.add(newRes);
                tempRes.remove(tempRes.lastIndexOf(node.val));
            } else if (node.left == null && node.right == null && tempSum != sum){
                tempRes.remove(tempRes.lastIndexOf(node.val));
                tempSum -= node.val;
            }

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }

        }
        return res;
    }
}
