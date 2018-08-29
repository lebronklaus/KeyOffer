package com.xiuhao;

import java.util.LinkedList;

/**
 * 包含min函数的栈
 */
public class Question30 {

    static LinkedList<Integer> stack1 = new LinkedList<>();
    static LinkedList<Integer> stack2 = new LinkedList<>();

    public static void main(String[] args) {
        push(3);
        System.out.println("top: "+top());
        System.out.println("min: "+min());
        push(4);
        System.out.println("top: "+top());
        System.out.println("min: "+min());
        push(2);
        System.out.println("top: "+top());
        System.out.println("min: "+min());
        push(1);
        System.out.println("top: "+top());
        System.out.println("min: "+min());
        pop();
        System.out.println("top: "+top());
        System.out.println("min: "+min());
        pop();
        System.out.println("top: "+top());
        System.out.println("min: "+min());
        push(0);
        System.out.println("top: "+top());
        System.out.println("min: "+min());
    }



    public static void push(int node){
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else {
            int num = stack2.peek();
            if(node<num){
                stack2.push(node);
            }else {
                stack2.push(num);
            }
        }
    }

    public static void pop(){
        System.out.println(stack1.pop());
        stack2.pop();
    }
    public static int top(){
        return stack1.peek();
    }

    public static int min(){
        return stack2.peek();
    }

}
