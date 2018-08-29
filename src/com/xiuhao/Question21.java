package com.xiuhao;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Question21 {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};
        reOrderWithOrigin(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void reOrderArray(int[] array){
        if(array==null||array.length==1){
            return ;
        }
        int beginIndex = 0;
        int endIndex = array.length-1;
        while(beginIndex < endIndex){
            while(beginIndex < endIndex&&(array[beginIndex]&0x1)!=0){
                beginIndex++;
            }
            while (beginIndex<endIndex&&(array[endIndex]&0x1)==0){
                endIndex--;
            }
            if(beginIndex < endIndex){
                int temp = array[beginIndex];
                array[beginIndex] = array[endIndex];
                array[endIndex] = temp;
            }
        }
    }

    //根据牛客要求，保证奇数和奇数，偶数和偶数之间的相对位置不变
    public static void reOrderWithOrigin(int[] array){
        int arrLength = array.length;
        if(array==null||arrLength==1){
            return;
        }
        int[] tempArr = new int[arrLength];
        for(int i=0;i<arrLength;i++){
            tempArr[i] = array[i];
            array[i] = 0;
        }
        int[] tempAr2 = new int[arrLength];
        int i,j=0,k=0;
        for(i=0;i<arrLength;i++){
            if((tempArr[i]&0x1)!=0){
                array[j++] = tempArr[i];
            }else{
                tempAr2[k++] = tempArr[i];
            }
        }
        int y = 0;
        for(int x=j;x<arrLength;x++){
            array[x]=tempAr2[y++];
        }
    }
}
