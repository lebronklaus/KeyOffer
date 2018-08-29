package com.xiuhao;

/**
 * 打印从1到最大的n位数
 */
public class Question17 {
    public static void main(String[] args) {
        printOneToNthDigits(3);
    }

    public static void printOneToNthDigits(int n){
        if(n<1){
            throw new RuntimeException("The input number must laeger than 0.");
        }
        int[] arr = new int[n];
        printOneToNthDigits(0,arr);
    }
    public static void printOneToNthDigits(int n,int[] arr){
        //说明所有的数据排列选择已经处理完了
        if(n>=arr.length){
            printArr(arr);
        }else{
            for(int i=0;i<=9;i++){
                arr[n] = i;
                printOneToNthDigits(n+1,arr);
            }
        }
    }
    public static void printArr(int[] arr){
        //找到第一个非0的元素
        int index = 0;
        while(index<arr.length&&arr[index]==0){
            index ++;
        }
        //从第一个非0值开始输出到最后一个元素
        for(int i=index;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        //条件成立说明数组中有非0元素，需要换行？
        if(index<arr.length){
            System.out.println();
        }
    }
}
