package NiuKe;

import java.util.ArrayList;
import java.util.Stack;

public class NC8_ {

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); //用于存储结果
    ArrayList<Integer> temp = new ArrayList<Integer>(); //用于存储路径

    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        dfs(root, sum, 0);
        return res;
    }

    private void dfs(TreeNode root, int sum, int preSum) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        preSum += root.val;
        if (root.left == null && root.right == null) {
            if (preSum == sum) {
                res.add(new ArrayList<Integer>((ArrayList<Integer>)temp.clone()));
            }
        }else {
            dfs (root.left, sum, preSum);
            dfs (root.right, sum, preSum);
        }
        temp.remove(temp.size() - 1);
    }
}
