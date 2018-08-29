package com.xiuhao;

import java.util.Stack;

/***
 * 用两个栈实现队列
 */
public class Question9 {

    public static void main(String[] args) {
        Question9 queue = new Question9();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop()+" "+queue.pop()+" "+queue.pop());
    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int val){
        stack1.push(val);
    }

    public int pop(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }
}
