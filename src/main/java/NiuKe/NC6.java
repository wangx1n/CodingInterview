package NiuKe;

public class NC6 {
    public int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    public int getMax(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(0,getMax(root.left));
        int rightMax = Math.max(0,getMax(root.right));
        //*1.--下面一行划重点--//
        res = Math.max(res,Math.max(root.val+Math.max(leftMax,rightMax),root.val+leftMax+rightMax));
        //*2--这一行也很重要--//
        return Math.max(leftMax,rightMax) + root.val;
    }
}
