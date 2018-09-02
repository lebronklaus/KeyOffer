package com.xiuhao;

/**
 * 二叉搜索树与双向链表
 */
public class Question36 {

    TreeNode head = null;
    TreeNode tail = null;

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

        Question36 q36 = new Question36();

        TreeNode list = q36.convert(node1);
        while(list!=null&&list.right!=null){
            System.out.print(list.val+" ");
            list = list.right;
        }
    }

    public TreeNode convert(TreeNode pRootOfTree){
        convertTree(pRootOfTree);

        return head;

    }
    public void convertTree(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return ;
        }
        convertTree(pRootOfTree.left);
        if(tail==null){
            tail = pRootOfTree;
            head = pRootOfTree;
        }else{
            tail.right = pRootOfTree;
            pRootOfTree.left = tail;
            tail = pRootOfTree;
        }
        convertTree(pRootOfTree.right);
    }
}
