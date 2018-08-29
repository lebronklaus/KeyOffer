package com.xiuhao;

/***
 * 斐波那契 & 青蛙跳台阶 & 变态青蛙跳台阶
 */
public class Question10 {

    public static void main(String[] args) {
        System.out.println("Fibonacci 10:"+fibonacci(10));
        System.out.println("frog 10:"+frog(10));
        System.out.println("angry frog 10:"+angryFrog(10));
    }

    public static int fibonacci(int n){
        int[] result = {0,1};
        if(n<2){
            return result[n];
        }
        int fibResult = 0;
        int fibOne = 0;
        int fibTwo = 1;
        for(int i=2;i<=n;i++){
            fibResult = fibOne+fibTwo;
            fibOne = fibTwo;
            fibTwo = fibResult;
        }
        return fibResult;
    }

    public static int frog(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return frog(n-1)+frog(n-2);
    }

    public static int angryFrog(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return 2*angryFrog(n-1);
    }
}
