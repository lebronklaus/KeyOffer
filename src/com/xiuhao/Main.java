package com.xiuhao;

import java.util.Scanner;

/**
 * Created by Lenovo on 2018/8/11.
 */
public class Main {
    public static void main(String[] args) {
//        int n;
//
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        int max =0;
//        for(int i=0;i<n;i++){
//            int x = scanner.nextInt();
//            if(absNum(x)>max){
//                max = x;
//            }
//            int y = scanner.nextInt();
//            if(absNum(y)>max){
//                max = y;
//            }
//        }
//        System.out.println(max*max);
        String str1 = new String("sss");
        System.out.println(str1.intern()==str1);
    }
    public static void test(){
        System.out.println("test");
    }
    public static int absNum(int x){
        if(x>0)
            return x;
        else
            return -x;
    }

}

abstract class Demo{
    private void p(Integer i){}

    private void p(int...i){}

}

enum Dem{
    a(),b(),c()
}
