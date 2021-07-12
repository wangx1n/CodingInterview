package NiuKe;

import sun.awt.image.ImageWatched;

import java.util.*;

public class NC14 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
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
            if ((results.size() + 1) % 2 == 0) {
                Collections.reverse(result);
                results.add(result);
            }else {
                results.add(result);
            }
        }
        return results;
    }
}
