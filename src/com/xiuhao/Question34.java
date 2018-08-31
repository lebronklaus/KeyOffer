package com.xiuhao;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 */
public class Question34 {

    static ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static int currentSum = 0;
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(12);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;

        ArrayList<ArrayList<Integer>> list = findPath(node1,22);
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++)
                System.out.print(list.get(i).get(j)+" ");
            System.out.println();
        }


    }
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

        if(root==null) {
            return resultList;
        }
        currentSum += root.val;
        list.add(root.val);
        if(currentSum==target&&root.right==null&&root.left==null){
            ArrayList<Integer> path = new ArrayList<>();
            for(int i=0;i<list.size();i++)
                    path.add(list.get(i));
            resultList.add(path);
        }
        if(currentSum<target&&root.left!=null){
            findPath(root.left,target);
        }
        if(currentSum<target&&root.right!=null){
            findPath(root.right,target);
        }
        currentSum -= root.val;
        list.remove(list.size()-1);
        return resultList;

    }
}
