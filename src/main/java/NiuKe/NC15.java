package NiuKe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class NC15 {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        if (root == null) return results;

        q.add(root);

        while(!q.isEmpty()) {
            ArrayList<Integer> result = new ArrayList<>();
            for(int i = q.size() - 1 ; i >= 0  ; i --) {
                TreeNode node = q.poll();
                result.add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            results.add(result);
        }
        return results;
    }
}
