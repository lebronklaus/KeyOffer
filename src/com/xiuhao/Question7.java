package com.xiuhao;

/***
 *  重建二叉树
 */
public class Question7 {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre,in);
        System.out.println(node.val);
    }

    public static TreeNode reConstructBinaryTree(int[] pre,int[] in){
        if(pre==null||in==null){
            return null;
        }
        //获取pre中第一个元素在in中的位置
        int count = 0;
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0]){
                count = i;
                break;
            }
        }
        int[] leftPre = count != 0 ? new int[count]:null;
        int[] leftIn = count != 0 ? new int[count]:null;
        int[] rightPre = count != pre.length-1 ? new int[pre.length-count-1]:null;
        int[] rightIn = count != pre.length-1 ? new int[pre.length-count-1]:null;

        for(int i=0;i<count;i++){
            leftPre[i] = pre[i+1];
            leftIn[i] = in[i];
        }

        for(int i=0;i<pre.length-count-1;i++){
            rightPre[i] = pre[count+1+i];
            rightIn[i] = in[count+1+i];
        }

        TreeNode node = new TreeNode(pre[0]);
        node.left = reConstructBinaryTree(leftPre,leftIn);
        node.right = reConstructBinaryTree(rightPre,rightIn);

        return node;

    }
}