package com.xiuhao;

import java.util.ArrayList;
import java.util.Stack;

/***
 * 从尾到头打印链表
 */
public class Question6 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(printLink(node1));

    }
    public static ArrayList<Integer> printLink(ListNode head){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
