package com.xiuhao;

/***
 * 数组中的重复数字
 */
public class Question3 {

    public static void main(String[] args) {
        int[] numbers = {2,3,1,0,2,5,3};
        System.out.println("duplicated num: "+findDuplicate(numbers));
    }

    public static int findDuplicate(int[] numbers){
        int length = numbers.length;
        for(int i=0;i<length;i++){
            if(numbers[i]<0||numbers[i]>length-1){
                return -1;
            }
        }
        for(int i=0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    return numbers[i];
                }
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
        }
        return -1;
    }

}
