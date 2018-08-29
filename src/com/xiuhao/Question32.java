package com.xiuhao;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下打印二叉树
 */
public class Question32 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        ArrayList<Integer> list = printFromTopToBottom(null);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }

    public static ArrayList<Integer> printFromTopToBottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return list;
        }

        queue.add(root);
        TreeNode currentNode;
        while(queue.size()!=0){//循环条件为!queue.isEmpty()时牛客网测试用例{}不通过
            currentNode = queue.poll();
            list.add(currentNode.val);
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
        return list;
    }

    //扩展：分行从上到下打印二叉树
    public static void printByRows(TreeNode root){
        LinkedList<Integer> queue = new LinkedList<>();
        if(root==null){
            return ;
        }
    }
}

