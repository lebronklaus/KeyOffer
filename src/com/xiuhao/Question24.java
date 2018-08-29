package com.xiuhao;

/**
 * 反转链表
 */
public class Question24 {

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
//        ListNode node = reverseList(node1);
        ListNode node = reverseListNode(node1);

        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }

    }

    public static ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode newHead = null;
        ListNode preNode = null;
        ListNode node = head;
        while(node!=null){
            ListNode nextNode = node.next;
            if(nextNode!=null){
                newHead = nextNode;
            }
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return newHead;
    }
    //基于尾插法实现
    public static ListNode reverseListNode(ListNode head){

        if(head == null){
            return null;
        }
        ListNode p = head.next;
        head.next=null;
        while(p!=null){
            ListNode q = new ListNode(0);
            q.val = p.val;
            q.next = head;
            head = q;
            p=p.next;
        }
        return head;
    }
}
