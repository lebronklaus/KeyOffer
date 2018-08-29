package com.xiuhao;

/**
 * 旋转数组的最小数字
 */
public class Question11 {

    public static void main(String[] args) {
        int[] array = {1,0,1,1,1};
        System.out.println(minNumberInRotateArray(array));
        System.out.println(minNumberByNowCoder(array));
    }

    //牛客不过？！运行超时: 您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
    public static int minNumberInRotateArray(int[] array){
        if(array.length==0){
            return 0;
        }
        int index1 = 0;
        int index2 = array.length-1;
        int indexMid = index1;

        while (array[index1] >= array[index2]) {
            if(index1-index2==1){
                indexMid = index2;
                break;
            }
            indexMid = (index1+index2)/2;

            if(array[index1]==array[index2]&&array[index1]==array[indexMid]){
                int result = array[index1];
                for(int i=index1+1;i<=index2;i++){
                    if(array[i]<result){
                        result = array[i];
                    }
                }
                return result;
            }

            if(array[indexMid]>=array[index1]){
                index1 = indexMid;
            }else if(array[indexMid]<=array[index2]){
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }

    //最坏的情况下O(n-1)
    public static int minNumberByNowCoder(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {
                if (i == array.length - 2) {
                    return array[0];
                }
            }
        }
        return 0;
    }

}
