package com.xiuhao;

/**
 * 数组中出现次数超过一半的数字
 */
public class Question39 {

    public static void main(String[] args) {

        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(findNumberMoreThanHalf(array));

    }

    public static int moreThanHalfNum_Solution(int[] array) {

        int length = array.length;
        if(array==null||length<=0)
            return 0;
        int result = array[0];
        int times = 1;
        for(int i=1;i<length;i++){
            if(times==0){
                result = array[i];
                times = 1;
            }else if(result==array[i]){
                times++;
            }else {
                times--;
            }
        }
        if(!checkIsHalf(array,result))
            return 0;
        return result;
    }
    public static boolean checkIsHalf(int[] array,int result){
        int length = array.length;
        int times = 0;
        for(int i=0;i<length;i++){
            if(array[i]==result){
                times++;
            }
        }
        if(times*2<=length){
            return false;
        }
        return true;
    }

    public static int findNumberMoreThanHalf(int[] array){
        if(array.length==0||array==null){
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int index = findMid(array,start,end);
        while (index!=array.length/2){
            if(index>array.length/2){
                end = index-1;
            }else {
                start = index+1;
            }
            index = findMid(array,start,end);
        }
        return checkIsHalf(array,array[index])?array[index]:-1;
    }
    public static int findMid(int[] array,int start,int end){
        int mid = array[start];
        int i = start;
        int j = end;
        while (i<j){
            while(i<j&&array[j]>=mid){
                j--;
            }
            if(i<j){
                array[i++] = array[j];
            }
            while (i<j&&array[i]<=mid){
                i++;
            }
            if(i<j){
                array[j--] = array[i];
            }
        }
        array[i] = mid;
        return i;
    }
}
