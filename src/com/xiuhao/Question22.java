package com.xiuhao;

import java.util.List;

/**
 * 链表中倒数第K个节点
 */
public class Question22 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(findKthToTail(node1,5).val);

    }

     public static ListNode findKthToTail(ListNode head,int k){
         if(head==null||k<=0){
             return null;
         }
         ListNode pre = head;
         ListNode behind = head;
         while(--k>0&&pre!=null){
             pre = pre.next;
         }
         if(pre==null){
             return null;
         }
         while(pre.next!=null){
             pre = pre.next;
             behind = behind.next;
         }
         return behind;
     }
}