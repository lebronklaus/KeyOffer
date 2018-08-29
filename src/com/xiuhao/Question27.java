package com.xiuhao;

/**
 * 二叉树的镜像
 */
public class Question27 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        TreeNode tree1 = node1;
        tree1.left = node2;
        tree1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;

        System.out.println("before mirror");
        printTree(tree1);
        mirror(tree1);
        System.out.println("\nafter mirror");
        printTree(tree1);
    }

    public static void mirror(TreeNode root){
        if(root==null){
            return ;
        }
        if(root.left==null&&root.right==null){
            return ;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left!=null){
            mirror(root.left);
        }
        if(root.right!=null){
            mirror(root.right);
        }
    }

    public static void printTree(TreeNode root) {
        if(root==null){
            return ;
        }
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }
}
