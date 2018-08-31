package com.xiuhao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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

        printByRows(node1);

        printLeftToRight(node1);

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
    //说明：toBePrinted表示这一层待打印的个数，nextLevelNode表示下一层节点数
    public static void printByRows(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return ;
        }
        int toBePrinted = 1;
        int nextLevelNode = 0;
        TreeNode currentNode;
        queue.add(root);
        while (queue.size()!=0){
            currentNode = queue.poll();
            System.out.print(currentNode.val+" ");
            if(currentNode.left!=null){
                queue.add(currentNode.left);
                nextLevelNode++;
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
                nextLevelNode++;
            }
            toBePrinted--;
            if(toBePrinted==0){
                System.out.println();
                toBePrinted = nextLevelNode;
                nextLevelNode = 0;
            }
        }

    }

    //扩展二：之字形打印二叉树
    public static void printLeftToRight(TreeNode root){
        if(root==null){
            return ;
        }
        int layer = 1;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.empty()||!s2.empty()){
            if(layer%2 !=0){
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.empty()){
                    TreeNode node = s1.pop();
                    if(node!=null){
                        temp.add(node.val);
                        System.out.print(node.val+" ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if(!temp.isEmpty()){
                    layer++;
                    System.out.println();
                }
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                while(!s2.empty()){
                    TreeNode node = s2.pop();
                    if(node!=null){
                        temp.add(node.val);
                        System.out.print(node.val+" ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()){
                    layer++;
                    System.out.println();
                }
            }
        }



    }
}

