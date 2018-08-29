package com.xiuhao;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class Question31 {

    public static void main(String[] args) {
        int[] pa = {1,2,3,4,5};
        int[] pb = {1,2,3,4,5};
        System.out.println(isPopOrder(pa,pb));
    }

    public static boolean isPopOrder(int[] pushA,int[] popA){
        int length = popA.length;
        int count = 0;
        if(pushA != null&&popA != null&&length != 0){
            for(int i = 0;i<length;i++){
                if(popA[i]==pushA[i])
                    count++;
            }
            if(count==length){
                return true;
            }
            int j = 1;
            Stack<Integer> pushStack = new Stack<>();
            pushStack.push(pushA[0]);
            for(int i=0;i<length;i++){
                while(pushStack.peek() != popA[i]&&j<length){
                    pushStack.push(pushA[j++]);
                }
                if(pushStack.peek()!=popA[i]){
                    return false;
                }
                pushStack.pop();
            }
            return true;
        }
        return false;
    }
}
