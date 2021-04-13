package RealInterView.Tencent;

import java.util.*;

/**
 * @author luccifer
 */
public class BitreePath {
    /*
    记录先序遍历
     */
    public ListNode[] solve (TreeNode root, int[] b) {
        ListNode[] listNodes = new ListNode[1000];
        for(int i = 0;i < b.length;i++){
            List<Integer> resut = findFather(root,b[i]);
            ListNode node = new ListNode(resut.get(resut.size()-1));
            ListNode currNode = node;
            if(resut.size() - 2 >=0){
                for(int j = resut.size()-2;j >= 0 ;j--){
                    ListNode newNode = new ListNode(resut.get(j));
                    currNode.next = newNode;
                    currNode = newNode;
                }
            }

            listNodes[i] = node;
        }

        return listNodes;
    }

    public static void main(String[] args) {
        BitreePath interview = new BitreePath();
        int[] a = {7,9};
        interview.solve(interview.buildTree(),a);
    }


    List<Integer> findFather(TreeNode root, int wantValue){

        ListNode node = new ListNode(root.val);

        List<Integer> list = new ArrayList<>();
        //最后一个数
        list.add(wantValue);

        //第一个是头就直接返回
        if(preOrder(root,wantValue).val == root.val)
        {
            node.next = null;
            return list;
        }

        //最后一个的前一个
        TreeNode treeNode = preOrder(root,wantValue);
        wantValue = treeNode.val;
        list.add(wantValue);

        //不断个更新每一层的root和value
        while(treeNode.val != root.val){
            treeNode = preOrder(root,wantValue);
            wantValue = treeNode.val;
            list.add(wantValue);
        }

        //list.add(root.val);
        ListNode currNode = node;
        //逆序将路径变成ListNode
        for(int i = list.size()-1;i>0;i--){
            ListNode newNode = new ListNode(i);
            currNode.next = newNode;
            currNode = newNode;
        }

        return list;


    }

    //先序遍历
    TreeNode preOrder(TreeNode root, int wantValue) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        //头节点直接返回
        if (wantValue == root.val) {
            return root;
        }

        //下一个是想找的数字，那么就返回
        if(root.left!=null && root.left.val == wantValue || root.right!=null && root.right.val == wantValue){
            return root;
        }

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();



            if (node.right != null) {

                if(node.right.val == wantValue)
                {
                    return node;
                }

                stack.push(node.right);
            }

            if (node.left != null) {

                if(node.left.val == wantValue)
                {
                    return node;
                }

                stack.push(node.left);
            }
        }

        return null;
    }

    public TreeNode buildTree(){
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);
        TreeNode root9 = new TreeNode(9);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        root4.left = root8;
        root4.right = root9;

        return root1;
    }




}




class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
