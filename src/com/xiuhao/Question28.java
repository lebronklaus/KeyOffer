package com.xiuhao;

/**
 * 对称的二叉树
 */
public class Question28 {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        node5.right = node7;

        System.out.println(isSymmetrical(node1));

    }

    //如果两棵树的前序遍历顺序一致，则为对称的二叉树
    public static boolean isSymmetrical(TreeNode root){
        return isSymmetrical(root,root);
    }
    public static boolean isSymmetrical(TreeNode root1, TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isSymmetrical(root1.left,root2.right)&&isSymmetrical(root1.right,root2.left);
    }
}
