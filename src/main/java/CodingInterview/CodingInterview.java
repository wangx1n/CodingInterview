package CodingInterview;

import java.util.HashMap;

/**
 * @program: CodingInterview.CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021-01-31 16:15
 *输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 **/
public class CodingInterview {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {

            return null;

        }

        int length = preorder.length;

        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

        for(int i = 0;i < length;i++){

            map.put(inorder[i],i);
        }

        TreeNode root = subTreeNode(preorder,0,length-1,inorder,0,length-1,map);

        return root;
    }

    //1.递归法
    public TreeNode subTreeNode(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap indexMap){

        if(preStart > preEnd){

            return null;
        }

        int rootValue = preorder[preStart];

        TreeNode treeNode = new TreeNode(rootValue);

        if(preStart == preEnd){
            return treeNode;
        }else{
            int rootIndex = (int) indexMap.get(rootValue);
            int leftLength = rootIndex - inStart; int rigthLength = inEnd - rootIndex;
            TreeNode leftNode = subTreeNode(preorder,preStart+1,preStart+leftLength,inorder, inStart, rootIndex - 1, indexMap);
            TreeNode rightNode = subTreeNode(preorder, preEnd - rigthLength + 1, preEnd, inorder, rootIndex + 1, inEnd, indexMap);
            treeNode.left = leftNode;
            treeNode.right = rightNode;
        }

        return treeNode;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}