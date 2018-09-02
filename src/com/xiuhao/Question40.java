package com.xiuhao;

import java.util.ArrayList;

/**
 * 最小的K个数
 */
public class Question40 {

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = minTopK(input,4);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }

    //思路一：快排
    public static ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(k<=0||k>input.length){
            return result;
        }
        if(k==input.length){
            for(int i=0;i<k;i++){
                result.add(input[i]);
            }
            return result;
        }
        int start = 0;
        int end = input.length-1;
        int index = Question39.findMid(input,start,end);
        while(index!=k){
            if(index<k){
                start = index+1;

            }else {
                end = index-1;
            }
            index = Question39.findMid(input,start,end);
        }
        for(int i=0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }

    //思路二：基于堆（大顶堆）
    public static ArrayList<Integer> minTopK(int[] input,int k){
        ArrayList<Integer> result = new ArrayList<>();
        if(k<=0||k>input.length){
            return result;
        }
        if(k==input.length){
            for(int i=0;i<k;i++){
                result.add(input[i]);
            }
            return result;
        }
        int[] arrayK = new int[k];
        for(int i=0;i<input.length;i++){
            if(i<k){
                arrayK[i] = input[i];
                if(i==k-1){
                    for(int j=k/2-1;j>=0;j--){
                        adjustHeapPosition(arrayK,j,k);
                    }
                }
            }else {
                if(input[i]<arrayK[0]){
                    arrayK[0] = input[i];
                    adjustHeapPosition(arrayK,0,k);
                }
            }
        }
        for(int i=0;i<k;i++){
            result.add(arrayK[i]);
        }
        return result;
    }

    /***
     * 构建大顶堆
     * @param array 待调整的序列
     * @param i 当前调整的位置
     * @param n 序列的逻辑长度
     */
    public static void adjustHeapPosition(int[] array,int i,int n){
        int child;
        int temp;

        for(temp = array[i];i*2+1<n;i=child){
            child = i*2+1;
            if(child!=n-1&&array[child]<array[child+1]){
                child++;
            }
            if(temp<array[child]){
                array[i] = array[child];
            }else {
                break;
            }
        }
        array[i] = temp;
    }

    public static void adjustHeap(int[] array,int i,int length){
        int temp = array[i];//先取出当前元素
        for(int k=2*i+1;k<length;k=k*2+1){//从i节点的左子节点开始
            if(k+1<length&&array[k]<array[k+1]){//如果左子节点小于右子节点，k指向右节点
                k++;
            }
            if(array[k]>temp){//如果子节点大于父节点，将子节点的值赋给父节点
                array[i] = array[k];
                i = k;
            }else{
                break;
            }
            array[i] = temp;//将temp的值放到最终的位置
        }
    }

}
