package com.xiuhao;

/***
 * 斐波那契 & 青蛙跳台阶 & 变态青蛙跳台阶
 */
public class Question10 {

    public static void main(String[] args) {
        System.out.println("Fibonacci 50:"+fibonacci(60));
        System.out.println("frog 10:"+frog(10));
        System.out.println("angry frog 10:"+angryFrog(10));
    }

    public static long fibonacci(int n){
        long[] result = {0,1};
        if(n<2){
            return result[n];
        }
        long fibResult = 0;
        long fibOne = 0;
        long fibTwo = 1;
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
