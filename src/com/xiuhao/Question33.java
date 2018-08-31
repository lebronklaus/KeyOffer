package com.xiuhao;

/**
 * 二叉搜索树的后序遍历序列
 */
public class Question33 {

    public static void main(String[] args) {
        int[] sequence = {5,7,6,9,11,10,8};
        System.out.println(verifySequenceOfBST(sequence));
    }

    public static boolean verifySequenceOfBST(int[] sequence){
        int length = sequence.length;
        if(sequence==null||length<=0){
            return false;
        }
        return verifySequenceOfBST(sequence,0,length-1);
    }

    public static boolean verifySequenceOfBST(int[] sequence,int start,int end){
        if(start>=end)
            return true;
        int index = start;

        while(index<end-1&&sequence[index]<sequence[end]){
            index++;
        }
        int right = index;
        while(index<end-1&&sequence[index]>sequence[end]){
            index++;
        }
        if(index!=end-1){
            return false;
        }
        index =right;
        return verifySequenceOfBST(sequence,start,index-1)&&verifySequenceOfBST(sequence,index,end-1);

//        int root = sequence[end];
//        //在二叉搜索树中左子树节点的值小于根节点的值
//        int i = 0;
//        for(;i<end;i++){
//            if(sequence[i]>root)
//                break;
//        }
//
//        //在二叉搜索树中右子树节点的值大于根节点的值
//        int j = i;
//        for(;j<end;j++){
//            if(sequence[j]<root){
//                return false;
//            }
//        }
//        //判断左子树
//        boolean left = true;
//        if(i>0){
//            left = verifySequenceOfBST(sequence,start,i-1);
//        }
//        //判断右子树
//        boolean right = true;
//        if(i<end){
//            right = verifySequenceOfBST(sequence,i,end-1);
//        }
//        return left&&right;
    }
}
