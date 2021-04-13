package NiuKe;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/30 20:37
 * 题目描述
 * 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 * 示例1
 * 输入
 * 复制
 * [3,5,1,6,2,0,8,#,#,7,4],5,1
 * 返回值
 * 复制
 * 3
 **/
public class NC102 {
//    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
//        // write code here
//        //如果当前节点为空，或者当前节点等于o1或者等于o2就返回值给父亲节点
//        if(root == null){
//            return 0;
//        }
//
//        //如果找到需要查找的值后，对于他的父节点那层循环来说，返回值即是找到的这个值。
//        if(root.val == o1 || root.val == o2){
//            return root.val;
//        }
//
//        int left = lowestCommonAncestor(root.left,o1,o2);
//        int right= lowestCommonAncestor(root.right,o1,o2);
//
//        //如果左右节点总有一个为0，说明只找到一个节点，所以返回值永远是找到的那个节点的值；
//        //当找到了最近公共祖先节点，即这个祖先节点的left和right分别是我们要找到o1，o2的值。则会返回当前这个公共祖先节点的值。
//        if(left == 0){
//            return right;
//        }
//        if(right == 0){
//            return left;
//        }
//        return root.val;
//    }
}
