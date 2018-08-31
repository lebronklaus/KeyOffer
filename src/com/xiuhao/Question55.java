package com.xiuhao;

/**
 * 二叉树的深度
 */
public class Question55 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(6);

        node1.left = node2;
        node1.right = node6;
        node2.left = node3;
        node2.right = node4;
        node4.left = node5;
        node6.right = node7;
        System.out.println(treeDepth(node1));

    }

    public static int treeDepth(TreeNode root){
        if(root==null)
            return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }
}
