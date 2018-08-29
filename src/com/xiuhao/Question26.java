package com.xiuhao;

import sun.reflect.generics.tree.Tree;

/**
 * 树的子结构
 */
public class Question26 {

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

        TreeNode tree2 = node3;
        tree2.left = node4;
        tree2.right = node5;

        System.out.println(hasSubtree(tree1,tree2));


    }

    //第一步判断两棵树是否存在值相同的节点
    public static boolean hasSubtree(TreeNode root1,TreeNode root2){
        boolean result = false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                result = isChild(root1,root2);
            }
            if(!result){
                result = hasSubtree(root1.left,root2);
            }
            if(!result){
                result = hasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    //第二步判断以该相同值节点为根的树是否是子树
    public static boolean isChild(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isChild(root1.left,root2.left)&&isChild(root1.right,root2.right);
    }
}
