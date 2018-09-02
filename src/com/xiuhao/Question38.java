package com.xiuhao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  字符串的排序
 */
public class Question38 {

    static ArrayList<String> resultList = new ArrayList<>();

    public static void main(String[] args) {
        String str;

        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        permutation(str);
        for(int i=0;i<resultList.size();i++){
            System.out.println(resultList.get(i));
        }

    }

    public static ArrayList<String> permutation(String str){
        int start = 0;
        int end = str.length()-1;
        char[] array = str.toCharArray();
        permutation(array,start,end);
        return resultList;
    }
    public static void permutation(char[] array,int start,int end){
        if(end<=1){
            return;
        }
        if(start==end){
            String str = new String(array);
            resultList.add(str);

        }else{
            for(int i=start;i<=end;i++){
                swap(array,i,start);
                permutation(array,start+1,end);
                swap(array,i,start);
            }
        }
    }

    public static void swap(char[] array,int m,int n){
        char temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
