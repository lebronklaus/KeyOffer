package com.xiuhao;

import java.util.List;

/**
 * 合并两个排序的链表
 */
public class Question25 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node3;
        node3.next = node5;
        node2.next = node4;
        node4.next = node6;

        ListNode node = merge(node1,node2);
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
    }

    //待完善，根据C语言的链表归并
    public static ListNode merge(ListNode list1,ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode pre;
        ListNode head;
        if(list1.val<list2.val){
            pre = list1;
            head = pre;
            list1 = list1.next;
        }else {
            pre = list2;
            head = pre;
            list2 = list2.next;
        }
        ListNode tail = head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                pre.next = list1;
                pre = list1;
                list1 = list1.next;

            }else{
                pre.next = list2;
                pre = list2;
                list2 = list2.next;
            }
        }
        if(list1!=null){
            pre.next = list1;
        }
        if(list2!=null){
            pre.next = list2;
        }
        return head;
    }

    //递归
    public static ListNode mergeList(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head = null;
        if(list1.val<list2.val){
            head = list1;
            head.next = mergeList(list1.next,list2);
        }else{
            head = list2;
            head.next = mergeList(list1,list2.next);
        }
        return head;
    }
}
