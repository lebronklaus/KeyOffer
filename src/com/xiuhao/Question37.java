package com.xiuhao;

import sun.reflect.generics.tree.Tree;

/**
 * 序列化二叉树
 * 序列化：遍历二叉树为字符串
 * 反序列化：依据字符串构造二叉树
 */
public class Question37 {
    static int index = -1;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        String str = Serialize(node1);
        System.out.println(str);

        TreeNode deSe = deSerialize(str);
        printTree(deSe);

    }

    public static String Serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    public static TreeNode deSerialize(String str){
        index++;
        String[] nodeVal = str.split(",");
        TreeNode node = null;
        if(!nodeVal[index].equals("#")){
            node = new TreeNode(Integer.valueOf(nodeVal[index]));
            node.left = deSerialize(str);
            node.right = deSerialize(str);
        }
        return node;
    }

    public static void printTree(TreeNode root){
        if(root==null)
            return ;
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }
}
