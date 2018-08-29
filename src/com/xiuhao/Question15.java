package com.xiuhao;

/**
 * 二进制中1的个数
 */
public class Question15 {
    public static void main(String[] args) {
        System.out.println("binary -9 contains 1:"+numberOf1(-1));
        System.out.println("is power 2:"+isPower2(15));
    }
    public static int numberOf1(int n){
        int count = 0;
        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }

    //扩展1：一条语句判断一个整数是不是2的整数次方
    public static boolean isPower2(int n){
        if((n&(n-1))==0){
            return true;
        }
        return false;
    }
}
