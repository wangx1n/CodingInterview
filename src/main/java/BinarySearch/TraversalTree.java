package BinarySearch;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.naming.LinkLoopException;
import java.util.*;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/21 16:31
 **/
public class TraversalTree {

    public static void main(String[] args) {
        TraversalTree traversalTree = new TraversalTree();
        LinkedList<TreeNode> list = traversalTree.preOrder(traversalTree.build());
        for (TreeNode node:list
             ) {
            System.out.print(node.nodeValue);
        }

        System.out.println();

        LinkedList<TreeNode> inOrderList = traversalTree.inOrder(traversalTree.build());
        for (TreeNode node:inOrderList
        ) {
            System.out.print(node.nodeValue);
        }

        LinkedList<Integer> postOrder = traversalTree.postOrder(traversalTree.build());

        System.out.println();

        StringBuffer stringBuffer = new StringBuffer(postOrder.toString());

        System.out.println(stringBuffer.reverse());

        String stringlin = "1,2,3";
        for (String i:stringlin.split(",")
             ) {
            System.out.println(Double.parseDouble(i));
        }

        LinkedList<Integer> levelOrder = traversalTree.levelOrderTraveral(traversalTree.build());
        for (Integer node:levelOrder
        ) {
            System.out.print(node);
        }


    }

    LinkedList<TreeNode> preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.rightNode != null) {
                stack.push(curr.rightNode);
            }
            if (curr.leftNode != null) {
                stack.push(curr.leftNode);
            }

            linkedList.add(curr);
        }
        return linkedList;
    }

    /**
     * levelorder
     * @param root
     * @return
     */
    LinkedList<Integer> levelOrderTraveral(TreeNode root){
        LinkedList<Integer> linkedList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            linkedList.add(node.nodeValue);

            if(node.leftNode != null){
                queue.offer(node.leftNode);
            }
            if(node.rightNode != null){
                queue.offer(node.rightNode);
            }

        }
        return linkedList;
    }


    LinkedList<TreeNode> inOrder(TreeNode root){
        LinkedList<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null){

            while(curr != null){

                stack.push(curr);

                curr = curr.leftNode;

            }

            if(!stack.isEmpty()){

                TreeNode temp = stack.pop();

                list.add(temp);

                curr = temp.rightNode;

            }
        }

        return list;
    }

    LinkedList<Integer> postOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.leftNode != null) {
                stack.push(curr.leftNode);
            }

            if (curr.rightNode != null) {
                stack.push(curr.rightNode);
            }


            linkedList.add(curr.nodeValue);
        }
        return linkedList;
    }

    public TreeNode build(){
        TreeNode treeNode5 = new TreeNode();
        treeNode5.nodeValue = 5;
        treeNode5.leftNode = null;
        treeNode5.rightNode = null;

        TreeNode treeNode3 = new TreeNode();
        treeNode3.nodeValue = 3;
        treeNode3.leftNode = null;
        treeNode3.rightNode = null;

        TreeNode treeNode2 = new TreeNode();
        treeNode2.nodeValue = 2;
        treeNode2.leftNode = treeNode5;
        treeNode2.rightNode = treeNode3;

        TreeNode treeNode4 = new TreeNode();
        treeNode4.nodeValue = 4;
        treeNode4.leftNode = null;
        treeNode4.rightNode = null;

        TreeNode treeNode1 = new TreeNode();
        treeNode1.nodeValue = 1;
        treeNode1.leftNode = treeNode2;
        treeNode1.rightNode = treeNode4;

        return treeNode1;
    }

}

class TreeNode{
    public int nodeValue;
    public TreeNode leftNode;
    public TreeNode rightNode;
}
