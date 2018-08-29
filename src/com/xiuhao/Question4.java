package com.xiuhao;

/***
 * 二维数组中的查找
 */
public class Question4 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean found = findNum(nums,15);
        System.out.println("found: "+found);
    }
    public static boolean findNum(int[][] nums,int key){
        int row = 0;
        int column = nums[0].length-1;
        if(nums==null||nums.length<=0||column<=0){
            return false;
        }
        while(row<nums.length&&column>=0){
            if(nums[row][column]==key){
                return true;
            }else if(nums[row][column]>key){
                column--;
            }else{
                row++;
            }
        }
        return false;
    }
}
